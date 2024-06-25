package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Title is required")
    private String title;

    @Column(nullable = false)
    @NotEmpty(message = "Author is required")
    private String author;

    private String publisher;

    @Column(nullable = false)
    @NotNull(message = "Publication year is required")
    private Integer publicationYear;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    private Integer stockQuantity;

    private String coverImageUrl;

    // Constructors

    public Book() {
    }

    public Book(String title, String author, Integer publicationYear, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    // Existing getters and setters...

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }
}
