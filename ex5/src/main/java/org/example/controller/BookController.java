package org.example.controller;

import org.example.model.Books;
import org.example.service.BookService;
import org.example.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Controller for handling book-related operations
 */
@Controller
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private CartService cartService;

    /**
     * Retrieves all books and displays them
     * @param model The model to add attributes to
     * @return The name of the view to display the book list
     */
    @GetMapping
    public String getAllBooks(Model model) {
        List<Books> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list";
    }

    /**
     * Retrieves a specific book by its ID
     * @param id The ID of the book to retrieve
     * @param model The model to add attributes to
     * @return The name of the view to display the book details, or a redirect to the error page if the book is not found
     */
    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model) {
        Books book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/error";
        }
        model.addAttribute("book", book);
        return "book-details";
    }

    /**
     * Displays the form for adding a new book
     * @param model The model to add attributes to
     * @return The name of the view to display the add book form
     */
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Books());
        return "add-book";
    }

    /**
     * Processes the addition of a new book
     * @param book The book to be added
     * @param coverImage The cover image file for the book
     * @return A redirect to the books list page, or to the error page if an exception occurs
     */
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Books book,
                          @RequestParam("coverImage") MultipartFile coverImage) {
        try {
            bookService.addBook(book, coverImage);
        } catch (IOException e) {
            logger.error("Error uploading file", e);
            return "redirect:/error";
        }
        return "redirect:/books";
    }

    /**
     * Deletes a book by its ID
     * @param id The ID of the book to be deleted
     * @return A confirmation message
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "Deleted book with id: " + id;
    }

    /**
     * Handles exceptions thrown by the controller methods
     * @param ex The exception that was thrown
     * @param model The model to add attributes to
     * @return The name of the error view
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        logger.error("An error occurred", ex);
        model.addAttribute("error", ex.getMessage());
        return "error";
    }

    /**
     * Adds a book to the user's cart
     * @param id The ID of the book to add to the cart
     * @param principal The currently authenticated user
     * @return A redirect to the cart page, or to the login page if the user is not authenticated
     */
    @PostMapping("/{id}/addToCart")
    public String addToCart(@PathVariable("id") Long id, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        Books book = bookService.getBookById(id);
        if (book != null) {
            cartService.addToCart(principal.getName(), book);
        }
        return "redirect:/cart";
    }
}