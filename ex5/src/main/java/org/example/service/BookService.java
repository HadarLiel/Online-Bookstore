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
            Books book1 = new Books();
            book1.setTitle("The No Show");
            book1.setAuthor("unknown");
            book1.setPrice(50.00);
            book1.setPublicationYear(2020);
            book1.setStockQuantity(10);
            book1.setCoverImageUrl("TheNoShow.png");
            book1.setDescription("This is a sample description for book1.");
            bookRepository.save(book1);

            Books book2 = new Books();
            book2.setTitle("Diary Of A Wimpy Kid");
            book2.setAuthor("Jeff Kinney");
            book2.setPrice(18.00);
            book2.setPublicationYear(2007);
            book2.setStockQuantity(40);
            book2.setCoverImageUrl("DiaryOfAWimpyKid.png");
            book2.setDescription("This is a sample description for Diary Of A Wimpy Kid.");
            bookRepository.save(book2);

            // New books to add
            Books book3 = new Books();
            book3.setTitle("Book Lovers");
            book3.setAuthor("Unknown");
            book3.setPrice(35.00);
            book3.setPublicationYear(2021);
            book3.setStockQuantity(15);
            book3.setCoverImageUrl("bookLovers.png");
            book3.setDescription("This is a sample description for Book Lovers.");
            bookRepository.save(book3);

            Books book4 = new Books();
            book4.setTitle("Rule Book");
            book4.setAuthor("Manual Writer");
            book4.setPrice(25.00);
            book4.setPublicationYear(2018);
            book4.setStockQuantity(30);
            book4.setCoverImageUrl("ruleBook.png");
            book4.setDescription("This is a sample description for Rule Book.");
            bookRepository.save(book4);

            Books book5 = new Books();
            book5.setTitle("Dracula");
            book5.setAuthor("Bram Stoker");
            book5.setPrice(15.00);
            book5.setPublicationYear(1897);
            book5.setStockQuantity(5);
            book5.setCoverImageUrl("dracula.png");
            book5.setDescription("This is a sample description for Dracula.");
            bookRepository.save(book5);

            Books book6 = new Books();
            book6.setTitle("Do Over");
            book6.setAuthor("Jon Acuff");
            book6.setPrice(20.00);
            book6.setPublicationYear(2017);
            book6.setStockQuantity(25);
            book6.setCoverImageUrl("doOver.png");
            book6.setDescription("This is a sample description for Do Over.");
            bookRepository.save(book6);

            Books book7 = new Books();
            book7.setTitle("A Tale Of Five Balloons");
            book7.setAuthor("Wale Ayeni");
            book7.setPrice(12.00);
            book7.setPublicationYear(2023);
            book7.setStockQuantity(8);
            book7.setCoverImageUrl("ATaleOfFiveBalloons.png");
            book7.setDescription("This is a sample description for A Tale Of Five Balloons.");
            bookRepository.save(book7);

            Books book8 = new Books();
            book8.setTitle("Harry Potter");
            book8.setAuthor("J.K. Rowling");
            book8.setPrice(40.00);
            book8.setPublicationYear(1997);
            book8.setStockQuantity(50);
            book8.setCoverImageUrl("harryPotter.png");
            book8.setDescription("This is a sample description for Harry Potter.");
            bookRepository.save(book8);

            Books book9 = new Books();
            book9.setTitle("Room For Rent");
            book9.setAuthor("Unknown");
            book9.setPrice(30.00);
            book9.setPublicationYear(2022);
            book9.setStockQuantity(12);
            book9.setCoverImageUrl("roomForRent.png");
            book9.setDescription("This is a sample description for Room For Rent.");
            bookRepository.save(book9);


    }


    public Books getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
}
