package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private String publisher;

    @Column(nullable = false)
    private Integer publicationYear;

    private String description;

    @Column(nullable = false)
    private Double price;

    private Integer stockQuantity;

    // Constructors, getters, and setters
}