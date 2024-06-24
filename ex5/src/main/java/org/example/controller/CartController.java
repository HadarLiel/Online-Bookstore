package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        List<Long> cart = (List<Long>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(id);
        session.setAttribute("cart", cart);
        return "redirect:/books";
    }

    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        List<Long> cartIds = (List<Long>) session.getAttribute("cart");
        List<Book> cartBooks = new ArrayList<>();
        if (cartIds != null) {
            for (Long id : cartIds) {
                Book book = bookService.getBookById(id);
                if (book != null) {
                    cartBooks.add(book);
                }
            }
        }
        model.addAttribute("cartBooks", cartBooks);
        return "cart/view";
    }
}