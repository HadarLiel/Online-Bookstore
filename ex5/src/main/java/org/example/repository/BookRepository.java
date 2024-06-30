package org.example.repository;

import org.example.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Books entities
 */
@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
    /**
     * Finds all books of a specific type
     * @param type The type of books to search for
     * @return A list of Books with the given type
     */
    List<Books> findByType(String type);

    /**
     * Finds all distinct book types in the database
     * @return A list of distinct book types
     */
    @Query("SELECT DISTINCT b.type FROM Books b")
    List<String> findDistinctTypes();
}