package org.example.controller;

import org.example.model.Books;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(@RequestParam(required = false) String type, Model model) {
        List<Books> books;
        if (type != null && !type.isEmpty()) {
            books = bookService.getBooksByType(type);
        } else {
            books = bookService.getAllBooks();
        }
        model.addAttribute("books", books);
        model.addAttribute("selectedType", type);
        model.addAttribute("bookTypes", bookService.getAllBookTypes()); // Assuming you have this method
        return "home";
    }
}
