package org.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @Column(nullable = false)
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern.List({
            @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain a digit"),
            @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain a lowercase letter"),
            @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain an uppercase letter"),
            @Pattern(regexp = "(?=.*[@#$%^&+=!_-]).+", message = "Password must contain a special character")
    })
    private String password;

    @Column(nullable = false)
    @Email(message = "Email should be valid")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_cart",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Books> cartItems = new ArrayList<>();

    public User() {
        // Default constructor required by JPA
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Books> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Books> cartItems) {
        this.cartItems = cartItems;
    }

    // toString() method (optional but recommended for logging and debugging)

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
