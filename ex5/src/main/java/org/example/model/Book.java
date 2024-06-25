package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String authorName;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int publicationYear;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private int stockQuantity;

    @Column(nullable = false)
    private String coverImageFileName;

    @Column(nullable = false)
    private LocalDateTime addedDate;

    // Constructors
    public Book() {
        this.addedDate = LocalDateTime.now(); // Initialize addedDate with current date/time
    }

    public Book(String title, String authorName, double price, int publicationYear, String publisher, int stockQuantity, String coverImageFileName) {
        this.title = title;
        this.authorName = authorName;
        this.price = price;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.stockQuantity = stockQuantity;
        this.coverImageFileName = coverImageFileName;
        this.addedDate = LocalDateTime.now(); // Initialize addedDate with current date/time
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCoverImageFileName() {
        return coverImageFileName;
    }

    public void setCoverImageFileName(String coverImageFileName) {
        this.coverImageFileName = coverImageFileName;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString() method (optional but recommended for logging and debugging)
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", coverImageFileName='" + coverImageFileName + '\'' +
                ", addedDate=" + addedDate +
                '}';
    }
}
