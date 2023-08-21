package de.user.rest.controller;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.user.persistence.entity.PassportEntity;
import de.user.service.impl.PassportService;
import de.user.persistence.exception.NotificationException;
import de.user.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Passport RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/passport")
public class PassportController {

    static final Logger LOG = LoggerFactory.getLogger(PassportController.class);

    @Autowired
    private PassportService passportService;

    @Operation(summary = "Get all passport")
    @GetMapping
    public List<PassportEntity> findAll() {
        return this.passportService.findAll();
    }

    @Operation(summary = "Get all passport without user")
    @GetMapping(value = "/find-without-user")
    public List<PassportEntity> findAllWithoutUser() {
        return passportService.findAllWithoutUser();
    }

    @Operation(summary = "Get all passport without other user")
    @GetMapping(value = "/find-without-other-user/{id}")
    public List<PassportEntity> findAllWithoutOtherUser(@PathVariable("id") Long id) {
        return passportService.findAllWithoutOtherUser(id);
    }

    @Operation(summary = "Get passport with id")
    @GetMapping(value = "/{id}")
    public PassportEntity findById(@PathVariable("id") Long id) {
        return this.passportService.findById(id);
    }

    @Operation(summary = "Create passport")
    @PostMapping
    public PassportEntity save(@Valid @RequestBody PassportEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update passport")
    @PutMapping
    public PassportEntity update(@Valid @RequestBody PassportEntity entity) {
        return passportService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete passport")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        passportService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Passport not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.passport.notfound", "Passport not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
