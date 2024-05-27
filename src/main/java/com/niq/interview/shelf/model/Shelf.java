package com.niq.interview.shelf.model;

import com.niq.interview.product.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "Shelf")
@Table(
        name = "shelf",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "product_id_shopper_id_unique",
                        columnNames = "categoryId_shopperId"
                )
        }
)
public class Shelf {

    @Id
    @SequenceGenerator(
            name = "shelf_sequence",
            sequenceName = "shelf_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shelf_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotBlank
    private String shopperId;

    private Double relevanceScore;

    public Shelf() {
    }

    public Shelf(Product product, String shopperId, Double relevanceScore) {
        this.product = product;
        this.shopperId = shopperId;
        this.relevanceScore = relevanceScore;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public Double getRelevanceScore() {
        return relevanceScore;
    }

    public void setRelevanceScore(Double relevanceScore) {
        this.relevanceScore = relevanceScore;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "product=" + product +
                ", shopperId='" + shopperId + '\'' +
                ", relevanceScore=" + relevanceScore +
                '}';
    }
}
