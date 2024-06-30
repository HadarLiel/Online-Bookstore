package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Represents a book in the bookstore system
 */
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

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String type;

    /**
     * Default constructor
     * Initializes addedDate with current date/time
     */
    public Books() {
        this.addedDate = LocalDateTime.now();
    }

    /**
     * Parameterized constructor
     * @param title The title of the book
     * @param coverImageUrl The URL of the book's cover image
     * @param author The author of the book
     * @param price The price of the book
     * @param publicationYear The year the book was published
     * @param stockQuantity The quantity of the book in stock
     * @param description A brief description of the book
     * @param type The type or genre of the book
     */
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
        this.addedDate = LocalDateTime.now();
    }

    // Getters and Setters
    /**
     * Gets the book's ID
     * @return The book's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the book's ID
     * @param id The ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the book's title
     * @return The book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the book's title
     * @param title The title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the URL of the book's cover image
     * @return The cover image URL
     */
    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    /**
     * Sets the URL of the book's cover image
     * @param coverImageUrl The cover image URL to set
     */
    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    /**
     * Gets the book's author
     * @return The book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the book's author
     * @param author The author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the book's price
     * @return The book's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the book's price
     * @param price The price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the book's publication year
     * @return The book's publication year
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets the book's publication year
     * @param publicationYear The publication year to set
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Gets the book's stock quantity
     * @return The book's stock quantity
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Sets the book's stock quantity
     * @param stockQuantity The stock quantity to set
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * Gets the date the book was added to the system
     * @return The date the book was added
     */
    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    /**
     * Sets the date the book was added to the system
     * @param addedDate The date to set
     */
    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * Gets the book's description
     * @return The book's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the book's description
     * @param description The description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the book's type or genre
     * @return The book's type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the book's type or genre
     * @param type The type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns a string representation of the Books object
     * @return A string representation of the Books object
     */
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