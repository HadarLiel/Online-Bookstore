package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auth/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            // Handle book not found scenario
            return "redirect:/error";
        }
        model.addAttribute("book", book);
        return "book-details";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping
    public String addBook(@ModelAttribute("book") Book book) {
        // Validate and process the book object, then save
        bookService.addBook(book);
        return "redirect:/auth/books";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "Deleted book with id: " + id;
    }
}
