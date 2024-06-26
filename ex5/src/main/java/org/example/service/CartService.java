package org.example.service;

import org.example.model.Books;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CartService {

    private final UserRepository userRepository;

    public CartService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Books> getCartItemsForUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getCartItems();
        }
        return Collections.emptyList();
    }

    public void addToCart(String username, Books book) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.getCartItems().add(book);
            userRepository.save(user);
        }
    }

    public void removeFromCart(String username, Long bookId) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.getCartItems().removeIf(book -> book.getId().equals(bookId));
            userRepository.save(user);
        }
    }
}
