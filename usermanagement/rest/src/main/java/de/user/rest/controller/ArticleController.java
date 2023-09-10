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

import de.user.persistence.entity.ArticleEntity;
import de.user.service.impl.ArticleService;
import de.user.persistence.exception.NotificationException;
import de.user.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Article RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/article")
public class ArticleController {

    static final Logger LOG = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Operation(summary = "Get all article")
    @GetMapping
    public List<ArticleEntity> findAll() {
        return this.articleService.findAll();
    }

    @Operation(summary = "Get all article without cart")
    @GetMapping(value = "/find-without-cart")
    public List<ArticleEntity> findAllWithoutCart() {
        return articleService.findAllWithoutCart();
    }

    @Operation(summary = "Get all article without other cart")
    @GetMapping(value = "/find-without-other-cart/{id}")
    public List<ArticleEntity> findAllWithoutOtherCart(@PathVariable("id") Long id) {
        return articleService.findAllWithoutOtherCart(id);
    }

    @Operation(summary = "Get article with id")
    @GetMapping(value = "/{id}")
    public ArticleEntity findById(@PathVariable("id") Long id) {
        return this.articleService.findById(id);
    }

    @Operation(summary = "Create article")
    @PostMapping
    public ArticleEntity save(@Valid @RequestBody ArticleEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update article")
    @PutMapping
    public ArticleEntity update(@Valid @RequestBody ArticleEntity entity) {
        return articleService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete article")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        articleService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Article not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.article.notfound", "Article not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
