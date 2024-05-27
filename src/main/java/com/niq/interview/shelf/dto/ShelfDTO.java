package com.niq.interview.shelf.dto;

import jakarta.validation.constraints.NotBlank;

public class ShelfDTO {
    @NotBlank
    private Long productId;
    @NotBlank
    private Double relevancyScore;

    public ShelfDTO(Long productId, Double relevancyScore) {
        this.productId = productId;
        this.relevancyScore = relevancyScore;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }
}
