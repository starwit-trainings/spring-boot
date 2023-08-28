package de.starwit.example.restdemo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
public class SampleRestController {

    private Logger log = LoggerFactory.getLogger(SampleRestController.class);

    @Autowired
    MyUserRepository repository;    

    @Operation(summary = "A fancy function")
    @GetMapping("/sample")
    ResponseEntity<Boolean> doStuff() {
        log.info("Sample service called");
        return ResponseEntity.ok(true);
    }

    @Operation(summary = "Get myusers")
    @GetMapping("/users")
    ResponseEntity<List<MyUser>> getMyUsers() {
        return ResponseEntity.ok(repository.findAll());
    }    

    @Operation(summary = "Create myuser")
    @PostMapping("/users")
    ResponseEntity<String> addMyUser(@Valid @RequestBody MyUser user) {
        repository.save(user);
        return ResponseEntity.ok("User is valid");
    }

    @Operation(summary = "Update myuser")
    @PutMapping("/users")
    ResponseEntity<Boolean> updateMyUsers(@Valid @RequestBody MyUser user) {
        //For Optional see https://www.baeldung.com/java-optional
        Optional<MyUser> existingUser = repository.findById(user.getId());
        if (existingUser.isPresent()) {
            MyUser u = existingUser.get();
            u.setEmail(user.getEmail());
            u.setName(user.getName());
            repository.save(u);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @Operation(summary = "Delete myuser")
    @DeleteMapping
    ResponseEntity<Boolean> deleteMyUser(long id) {
        Optional<MyUser> existingUser = repository.findById(id);
        if (existingUser.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }        
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
    MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    } 

}
