package org.example.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart in the session scope
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Books> cartItems = new ArrayList<>();

    /**
     * Adds a book to the cart
     * @param book The book to add to the cart
     */
    public void addToCart(Books book) {
        cartItems.add(book);
    }

    /**
     * Removes a book from the cart
     * @param bookId The ID of the book to remove
     */
    public void removeFromCart(Long bookId) {
        cartItems.removeIf(book -> book.getId().equals(bookId));
    }

    /**
     * Gets all items in the cart
     * @return A list of Books in the cart
     */
    public List<Books> getCartItems() {
        return cartItems;
    }

    /**
     * Calculates the total price of all items in the cart
     * @return The total price of all items in the cart
     */
    public double getTotalPrice() {
        return cartItems.stream().mapToDouble(Books::getPrice).sum();
    }

    /**
     * Clears all items from the cart
     */
    public void clearCart() {
        cartItems.clear();
    }
}