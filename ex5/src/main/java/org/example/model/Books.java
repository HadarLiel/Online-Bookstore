package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "cover_image_url", nullable = false)
    private String coverImageUrl;

    @Column(nullable = false)
    private String author = "";

    @Column(nullable = false)
    private double price;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    @Column(name = "added_date", nullable = false)
    private LocalDateTime addedDate;

    @Column(nullable = false, length = 1000) // Adjust length based on your description's requirements
    private String description;

    @Column(nullable = false) // Add the new type column
    private String type;

    // Constructors
    public Books() {
        this.addedDate = LocalDateTime.now(); // Initialize addedDate with current date/time
    }

    public Books(String title, String coverImageUrl, String author, double price, int publicationYear,
                 int stockQuantity, String description, String type) {
        this.title = title;
        this.coverImageUrl = coverImageUrl;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.type = type;
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

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                ", stockQuantity=" + stockQuantity +
                ", addedDate=" + addedDate +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
