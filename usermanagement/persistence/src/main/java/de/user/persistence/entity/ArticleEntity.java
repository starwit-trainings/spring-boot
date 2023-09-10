package de.user.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;
import de.user.persistence.serializer.ZonedDateTimeSerializer;
import de.user.persistence.serializer.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.CascadeType;

/**
 * Article Entity class
 */
@Entity
@Table(name = "article")
public class ArticleEntity extends AbstractEntity<Long> {

    // entity fields
    @Column(name = "name")
    private String name;


    @Column(name = "color")
    private String color;


    @Column(name = "price")
    private Double price;


    @Column(name = "weight")
    private Double weight;


    // entity relations
    @JsonFilter("filterId")
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    // entity fields getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    // entity relations getters and setters
    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

}
