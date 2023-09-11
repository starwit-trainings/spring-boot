package de.user.rest.controller;

import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import de.user.persistence.entity.ArticleEntity;
import de.user.persistence.entity.CartEntity;
import de.user.persistence.exception.NotificationException;
import de.user.rest.exception.NotificationDto;
import de.user.service.ArticleDTO;
import de.user.service.CartBean;
import de.user.service.CartDTO;
import de.user.service.impl.CartManagementService;
import de.user.service.impl.CartService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/**
 * Cart RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping(path = "${rest.base-path}/cart")
public class CartController {

    static final Logger LOG = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @Autowired
    private ObjectMapper objectMapper; 

    @Autowired
    private CartManagementService cartManagementService;


    /*
     * TODO
     * write REST methods for
     *  - creating new cart
     *  - add article to cart
     *  - checkout cart
     */

    @Operation(summary = "Get Session Bean")
    @GetMapping(value = "/session")
    public ResponseEntity<CartDTO> getCurrentCartContent() {
        return ResponseEntity.ok(cartManagementService.getCartBean());
    }

    @Operation(summary = "Add article to cart")
    @PutMapping(value = "/session")
    public ResponseEntity<List<ArticleDTO>> addArticleToCart(@Valid @RequestBody ArticleEntity entity) {
        cartManagementService.addArticleToCart(entity);
        return ResponseEntity.ok(cartManagementService.getCartBean().getArticles());       
    }

    @Operation(summary = "Checkout cart")
    @GetMapping(value = "/session/checkout")
    public ResponseEntity<Boolean> checkOutCart() {
        //TODO
        return ResponseEntity.ok(false);
    }

    @Operation(summary = "Reset shopping cart")
    @DeleteMapping(value = "/session")
    public ResponseEntity<Boolean> resetCart() {
        // TODO
        return ResponseEntity.ok(false);       
    }

    @Operation(summary = "Get all cart")
    @GetMapping
    public List<CartEntity> findAll() {
        return this.cartService.findAll();
    }

    @Operation(summary = "Get cart with id")
    @GetMapping(value = "/{id}")
    public CartEntity findById(@PathVariable("id") Long id) {
        return this.cartService.findById(id);
    }

    @Operation(summary = "Create cart")
    @PostMapping
    public CartEntity save(@Valid @RequestBody CartEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update cart")
    @PutMapping
    public CartEntity update(@Valid @RequestBody CartEntity entity) {
        return cartService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete cart")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        cartService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Cart not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.cart.notfound", "Cart not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
