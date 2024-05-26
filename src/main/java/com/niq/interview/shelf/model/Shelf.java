package com.niq.interview.shelf.model;

import com.niq.interview.category.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity(name = "Shelf")
@Table(
        name = "shelf",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "category_id_shopper_id_unique",
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
    @JoinColumn(name = "category_id")
    private Category category;

    @NotBlank
    private String shopperId;

    private Double relevanceScore;

    public Shelf() {
    }

    public Shelf(Category category, String shopperId, Double relevanceScore) {
        this.category = category;
        this.shopperId = shopperId;
        this.relevanceScore = relevanceScore;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shelf shelf)) return false;
        return Objects.equals(id, shelf.id) && Objects.equals(getCategory(), shelf.getCategory()) && Objects.equals(getShopperId(), shelf.getShopperId()) && Objects.equals(getRelevanceScore(), shelf.getRelevanceScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getCategory(), getShopperId(), getRelevanceScore());
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "category=" + category +
                ", shopperId='" + shopperId + '\'' +
                ", relevanceScore=" + relevanceScore +
                '}';
    }
}
