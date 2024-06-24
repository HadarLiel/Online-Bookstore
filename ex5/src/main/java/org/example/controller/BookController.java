package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    @GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @PostMapping
    public String saveBook(@ModelAttribute Book book, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Save the file
                String uploadDir = "src/main/resources/static/images/";
                String fileName = file.getOriginalFilename();
                Path path = Paths.get(uploadDir + fileName);
                Files.write(path, file.getBytes());

                // Set the cover image URL
                book.setCoverImageUrl("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/detail";
    }
}