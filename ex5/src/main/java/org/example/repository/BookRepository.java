package org.example.repository;

import org.example.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
    List<Books> findByType(String type);
    @Query("SELECT DISTINCT b.type FROM Books b")
    List<String> findDistinctTypes();
}
