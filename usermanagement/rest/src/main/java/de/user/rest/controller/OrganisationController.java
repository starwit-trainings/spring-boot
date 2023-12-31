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

import de.user.persistence.entity.OrganisationEntity;
import de.user.service.impl.OrganisationService;
import de.user.persistence.exception.NotificationException;
import de.user.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Organisation RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/organisation")
public class OrganisationController {

    static final Logger LOG = LoggerFactory.getLogger(OrganisationController.class);

    @Autowired
    private OrganisationService organisationService;

    @Operation(summary = "Get all organisation")
    @GetMapping
    public List<OrganisationEntity> findAll() {
        return this.organisationService.findAll();
    }

    @Operation(summary = "Get all organisation without address")
    @GetMapping(value = "/find-without-address")
    public List<OrganisationEntity> findAllWithoutAddress() {
        return organisationService.findAllWithoutAddress();
    }

    @Operation(summary = "Get all organisation without other address")
    @GetMapping(value = "/find-without-other-address/{id}")
    public List<OrganisationEntity> findAllWithoutOtherAddress(@PathVariable("id") Long id) {
        return organisationService.findAllWithoutOtherAddress(id);
    }

    @Operation(summary = "Get organisation with id")
    @GetMapping(value = "/{id}")
    public OrganisationEntity findById(@PathVariable("id") Long id) {
        return this.organisationService.findById(id);
    }

    @Operation(summary = "Create organisation")
    @PostMapping
    public OrganisationEntity save(@Valid @RequestBody OrganisationEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update organisation")
    @PutMapping
    public OrganisationEntity update(@Valid @RequestBody OrganisationEntity entity) {
        return organisationService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete organisation")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        organisationService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Organisation not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.organisation.notfound", "Organisation not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
