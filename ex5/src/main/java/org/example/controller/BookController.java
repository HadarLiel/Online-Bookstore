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

@Controller
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private CartService cartService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Books> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model) {
        Books book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/error";
        }
        model.addAttribute("book", book);
        return "book-details";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Books());
        return "add-book";
    }

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

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "Deleted book with id: " + id;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        logger.error("An error occurred", ex);
        model.addAttribute("error", ex.getMessage());
        return "error";
    }

    @PostMapping("/{id}/addToCart")
    public String addToCart(@PathVariable("id") Long id, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        Books book = bookService.getBookById(id);
        if (book != null) {
            cartService.addToCart(principal.getName(), book);
        }
        return "redirect:/cart"; // This will redirect to the cart page after adding the item
    }
}