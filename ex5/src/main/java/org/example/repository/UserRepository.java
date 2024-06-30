package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entities
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by their username
     * @param username The username to search for
     * @return The User with the given username, or null if not found
     */
    User findByUsername(String username);

    /**
     * Finds a user by their email address
     * @param email The email address to search for
     * @return The User with the given email, or null if not found
     */
    User findByEmail(String email);
}