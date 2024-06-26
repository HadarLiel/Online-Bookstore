package org.example.controller;

import org.example.model.Books;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Books> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list"; // Renders book-list.html Thymeleaf template
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model) {
        Books book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/error"; // Redirects to error page if book not found
        }
        model.addAttribute("book", book);
        return "book-details"; // Renders book-details.html Thymeleaf template
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Books());
        return "add-book"; // Renders add-book.html Thymeleaf template
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Books book,
                          @RequestParam("coverImage") MultipartFile coverImage) {
        try {
            bookService.addBook(book, coverImage);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/error"; // Redirects to error page if there's an issue with the file upload
        }
        return "redirect:/books"; // Redirects to book list after adding book
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "Deleted book with id: " + id; // Returns message confirming deletion
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error"; // Renders error.html Thymeleaf template
    }
}
