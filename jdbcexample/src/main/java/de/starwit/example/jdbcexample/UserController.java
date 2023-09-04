package de.starwit.example.jdbcexample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    MyService service;

    @Autowired
    MyUserRepository repository;

    @GetMapping("/test/{pattern}")
    public ResponseEntity<List<MyUser>> filterUsers(@PathVariable("pattern") String pattern) {
        List<MyUser> users = repository.findByNameContains(pattern);
        return ResponseEntity.ok(users);
    } 

    @GetMapping("/test2/{pattern}")
    public ResponseEntity<List<MyUser>> filterUsers2(@PathVariable("pattern") String pattern) {
        List<MyUser> users = repository.getUsersByName(pattern);
        return ResponseEntity.ok(users);
    } 

    @PostMapping("/users")
    ResponseEntity<String> addMyUser(@Valid @RequestBody MyUser user) {
        try {
            repository.save(user);
            return ResponseEntity.ok("User is valid");
        } catch (DataIntegrityViolationException e) {
            log.info("User couldn't be added " + e.getMessage());
            return ResponseEntity.ok("User is not valid");
        }
    }

    @GetMapping("/users")
    ResponseEntity<List<MyUser>> doStuff() {
        return ResponseEntity.ok(repository.findAll());
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
