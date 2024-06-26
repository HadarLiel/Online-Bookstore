package org.example.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Books> cartItems = new ArrayList<>();

    public void addToCart(Books book) {
        cartItems.add(book);
    }

    public void removeFromCart(Long bookId) {
        // Remove the book with matching ID from cartItems
        cartItems.removeIf(book -> book.getId().equals(bookId));
    }

    public List<Books> getCartItems() {
        return cartItems;
    }

    public double getTotalPrice() {
        // Calculate total price logic here
        return cartItems.stream().mapToDouble(Books::getPrice).sum();
    }

    public void clearCart() {
        cartItems.clear();
    }
}
