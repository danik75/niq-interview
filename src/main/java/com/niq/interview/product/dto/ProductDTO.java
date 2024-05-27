package com.niq.interview.product.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductDTO {

    private Long id;

    @NotBlank
    private String category;

    @NotBlank
    private String brand;

    public ProductDTO(Long id, String category, String brand) {
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
