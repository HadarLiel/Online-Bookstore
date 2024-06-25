package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book") // Specify the table name if it's different from the class name
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(name = "cover_image_url", nullable = false)
    private String coverImageUrl;

    @Column(nullable = false)
    private double price;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @Column(nullable = false)
    private String publisher;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    // Additional fields as per your database schema
    @Column(name = "author_name")
    private String authorName;

    @Column(name = "name")
    private String name;

    @Column(name = "added_date", nullable = false)
    private LocalDateTime addedDate;

    // Constructors
    public Book() {
        this.addedDate = LocalDateTime.now(); // Initialize addedDate with current date/time
    }

    public Book(String title, String author, String coverImageUrl, double price, int publicationYear,
                String publisher, int stockQuantity, String authorName, String name) {
        this.title = title;
        this.author = author;
        this.coverImageUrl = coverImageUrl;
        this.price = price;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.stockQuantity = stockQuantity;
        this.authorName = authorName;
        this.name = name;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
                ", author='" + author + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", authorName='" + authorName + '\'' +
                ", name='" + name + '\'' +
                ", addedDate=" + addedDate +
                '}';
    }

}
