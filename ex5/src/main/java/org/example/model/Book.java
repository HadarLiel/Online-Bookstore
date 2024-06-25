package org.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String coverImageUrl;

    private LocalDateTime addedDate;

    @ManyToOne(fetch = FetchType.LAZY) // Ensure proper lazy loading
    @JoinColumn(name = "added_by", nullable = false)
    private User addedBy;

    // Constructors

    public Book() {
        // Default constructor required by JPA
    }

    public Book(String title, String author, String description, String coverImageUrl, LocalDateTime addedDate, User addedBy) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.addedDate = addedDate;
        this.addedBy = addedBy;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    // toString() method (optional but recommended for logging and debugging)

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", addedDate=" + addedDate +
                ", addedBy=" + addedBy +
                '}';
    }
}
