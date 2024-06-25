package org.example.service;

import org.example.model.Books;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BookService {

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Books book, MultipartFile coverImage) throws IOException {
        if (coverImage != null && !coverImage.isEmpty()) {
            String fileName = coverImage.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(coverImage.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            book.setCoverImageUrl(fileName); // Set the cover image URL based on file name
        }

        book.setAddedDate(LocalDateTime.now());
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @PostConstruct
    public void initData() {
        if (bookRepository.count() == 0) {
            Books book1 = new Books();
            book1.setTitle("The Most");
            book1.setAuthor("Jessica Anthony");
            book1.setPrice(50.00);
            book1.setPublicationYear(2020);
            book1.setStockQuantity(10);
            book1.setCoverImageUrl("TheMost.png");
            bookRepository.save(book1);

            Books book2 = new Books();
            book2.setTitle("Another Book");
            book2.setAuthor("Another Author");
            book2.setPrice(45.00);
            book2.setPublicationYear(2019);
            book2.setStockQuantity(20);
            book2.setCoverImageUrl("TheMost.png");
            bookRepository.save(book2);
        }
    }

    public Books getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
}
