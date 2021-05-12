package com.shopapp.frontpageservice.controller;

import com.shopapp.frontpageservice.service.BasketCollectorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ViewController {
    private final BasketCollectorService basketCollectorService;

    public ViewController(BasketCollectorService basketCollectorService) {
        this.basketCollectorService = basketCollectorService;
    }

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/shopping")
    public String customers(Principal principal, Model model) {
        model.addAttribute("books", basketCollectorService.getBasket().getBooks());
        model.addAttribute("username", principal.getName());
        return "shopping";
    }

}
