package de.starwit.batchexample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ARTICLE")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank(message = "article name")
    private String name;
       
    @Min(0)
    private double price;

    @Min(0)
    private double weight;

    @NotBlank(message = "Color is mandatory for every article")
    private String color;

    public Article() {}
    
    public Article(@NotBlank(message = "article name") String name, @Min(0) double price, @Min(0) double weight,
            @NotBlank(message = "Color is mandatory for every article") String color) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", name=" + name + ", price=" + price + ", weight=" + weight + ", color=" + color
                + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
