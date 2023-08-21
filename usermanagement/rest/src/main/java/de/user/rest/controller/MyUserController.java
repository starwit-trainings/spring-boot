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

import de.user.persistence.entity.MyUserEntity;
import de.user.service.impl.MyUserService;
import de.user.persistence.exception.NotificationException;
import de.user.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * MyUser RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/myuser")
public class MyUserController {

    static final Logger LOG = LoggerFactory.getLogger(MyUserController.class);

    @Autowired
    private MyUserService myuserService;

    @Operation(summary = "Get all myuser")
    @GetMapping
    public List<MyUserEntity> findAll() {
        return this.myuserService.findAll();
    }

    @Operation(summary = "Get all myuser without address")
    @GetMapping(value = "/find-without-address")
    public List<MyUserEntity> findAllWithoutAddress() {
        return myuserService.findAllWithoutAddress();
    }

    @Operation(summary = "Get all myuser without other address")
    @GetMapping(value = "/find-without-other-address/{id}")
    public List<MyUserEntity> findAllWithoutOtherAddress(@PathVariable("id") Long id) {
        return myuserService.findAllWithoutOtherAddress(id);
    }

    @Operation(summary = "Get myuser with id")
    @GetMapping(value = "/{id}")
    public MyUserEntity findById(@PathVariable("id") Long id) {
        return this.myuserService.findById(id);
    }

    @Operation(summary = "Create myuser")
    @PostMapping
    public MyUserEntity save(@Valid @RequestBody MyUserEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update myuser")
    @PutMapping
    public MyUserEntity update(@Valid @RequestBody MyUserEntity entity) {
        return myuserService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete myuser")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        myuserService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("MyUser not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.myuser.notfound", "MyUser not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
