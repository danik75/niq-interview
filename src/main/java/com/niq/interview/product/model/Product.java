package com.niq.interview.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "category_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    private Long id;

    @NotBlank
    private String category;

    @NotBlank
    private String brand;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String category, String brand) {
        this.id = id;
        this.category = category;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


}
