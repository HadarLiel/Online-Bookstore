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

        // Existing books
        Books book1 = new Books("The No Show", "TheNoShow.png", "unknown", 50.00, 2020, 10, "This is a sample description for book1.", "Fiction");
        bookRepository.save(book1);

        Books book2 = new Books("Diary Of A Wimpy Kid", "DiaryOfAWimpyKid.png", "Jeff Kinney", 18.00, 2007, 40, "This is a sample description for Diary Of A Wimpy Kid.", "Children");
        bookRepository.save(book2);

        // New books to add
        Books book3 = new Books("Book Lovers", "bookLovers.png", "Unknown", 35.00, 2021, 15, "This is a sample description for Book Lovers.", "Romance");
        bookRepository.save(book3);

        Books book4 = new Books("Rule Book", "ruleBook.png", "Manual Writer", 25.00, 2018, 30, "This is a sample description for Rule Book.", "Manual");
        bookRepository.save(book4);

        Books book5 = new Books("Dracula", "dracula.png", "Bram Stoker", 15.00, 1897, 5, "This is a sample description for Dracula.", "Horror");
        bookRepository.save(book5);

        Books book6 = new Books("Do Over", "doOver.png", "Jon Acuff", 20.00, 2017, 25, "This is a sample description for Do Over.", "Self-Help");
        bookRepository.save(book6);

        Books book7 = new Books("A Tale Of Five Balloons", "ATaleOfFiveBalloons.png", "Wale Ayeni", 12.00, 2023, 8, "This is a sample description for A Tale Of Five Balloons.", "Children");
        bookRepository.save(book7);

        Books book8 = new Books("Harry Potter", "harryPotter.png", "J.K. Rowling", 40.00, 1997, 50, "This is a sample description for Harry Potter.", "Fantasy");
        bookRepository.save(book8);

        Books book9 = new Books("Room For Rent", "roomForRent.png", "Unknown", 30.00, 2022, 12, "This is a sample description for Room For Rent.", "Thriller");
        bookRepository.save(book9);
    }

    public Books getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
}
