package com.shopapp.frontpageservice.controller;

import com.shopapp.frontpageservice.model.Basket;
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
        Basket basket  = basketCollectorService.getBasket();
        model.addAttribute("books", basket.getBooks());
        model.addAttribute("jackets", basket.getJackets());
        model.addAttribute("tshirts", basket.getTshirts());
        model.addAttribute("shoes", basket.getShoes());
        model.addAttribute("username", principal.getName());
        return "shopping";
    }

}
