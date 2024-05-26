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
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;


    private Long categoryId;

    @NotBlank
    private String shopperId;

    private Double relevanceScore;

    public Shelf() {
    }

    public Shelf(Long categoryId, String shopperId, Double relevanceScore) {
        this.categoryId = categoryId;
        this.shopperId = shopperId;
        this.relevanceScore = relevanceScore;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
        return Objects.equals(getCategoryId(), shelf.getCategoryId()) && Objects.equals(getShopperId(), shelf.getShopperId()) && Objects.equals(getRelevanceScore(), shelf.getRelevanceScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getShopperId(), getRelevanceScore());
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "category=" + categoryId +
                ", shopperId='" + shopperId + '\'' +
                ", relevanceScore=" + relevanceScore +
                '}';
    }
}
