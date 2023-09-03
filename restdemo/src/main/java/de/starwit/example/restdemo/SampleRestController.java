package de.starwit.example.restdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "${rest.base-path}/user")
public class SampleRestController {

    private Logger log = LoggerFactory.getLogger(SampleRestController.class);

    @Autowired
    MyUserRepository repository;

    @Autowired
    ScopedBean scopedBean;

    @Operation(summary = "A fancy function")
    @GetMapping("/scope")
    ResponseEntity<Integer> beanScopeDemo() {
        log.info("Scope demo called");
        return ResponseEntity.ok(scopedBean.getNumber());
    }    

    @Operation(summary = "A fancy function")
    @GetMapping("/sample")
    ResponseEntity<Boolean> doStuff() {
        log.info("Sample service called");
        return ResponseEntity.ok(true);
    }

    @Operation(summary = "Bulk Import")
    @PostMapping("/import")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    String importUsers() {
        log.info("Not implemented yet");
        /*
         * TODO Build a function, that gets a list of users and 
         * add each user. Every user shall be validated. 
         */
        return "Service not implemented yet";
    }    

    @Operation(summary = "Get myusers")
    @GetMapping
    ResponseEntity<List<MyUser>> getMyUsers() {
        return ResponseEntity.ok(repository.findAll());
    }
    
    @Operation(summary = "Get myusers")
    @GetMapping("/{id}")
    ResponseEntity<MyUser> getMyUsersByID(@PathVariable("id") Long id) {
        Optional<MyUser> user = repository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return new ResponseEntity<MyUser>(new MyUser(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Create myuser")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<String> addMyUser(@Valid @RequestBody MyUser user) {
        repository.save(user);
        return ResponseEntity.ok("User is valid");
    }

    @Operation(summary = "Update myuser")
    @PutMapping
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
