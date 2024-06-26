package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.example.model.User;
import org.example.service.CartService;
import org.example.model.Books;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        List<Books> cartItems = cartService.getCartItemsForUser(principal.getName());
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartEmpty", cartItems.isEmpty());
        model.addAttribute("message", cartItems.isEmpty() ? "Your cart is empty." : null);

        return "cart"; // This should be the name of your cart view template
    }
}