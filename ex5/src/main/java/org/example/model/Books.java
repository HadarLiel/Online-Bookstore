package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "books") // Ensure table name matches what you want in your database
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

    // Additional fields as per your database schema
    @Column(name = "added_date", nullable = false)
    private LocalDateTime addedDate;

    // Constructors
    public Books() {
        this.addedDate = LocalDateTime.now(); // Initialize addedDate with current date/time
    }

    public Books(String title, String coverImageUrl, String author, double price, int publicationYear,
                int stockQuantity) {
        this.title = title;
        this.coverImageUrl = coverImageUrl;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
        this.stockQuantity = stockQuantity;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
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

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    // toString() method (optional but recommended for logging and debugging)
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", author='" + author + '\''+
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                ", stockQuantity=" + stockQuantity +
                ", addedDate=" + addedDate +
                '}';
    }


}
