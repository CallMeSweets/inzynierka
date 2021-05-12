package com.shopapp.frontpageservice.controller;

import com.shopapp.frontpageservice.model.Basket;
import com.shopapp.frontpageservice.service.BasketCollectorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/front")
public class FrontServiceController {

    private final BasketCollectorService basketCollectorService;
    private Basket basket;

    public FrontServiceController(BasketCollectorService basketCollectorService) {
        this.basketCollectorService = basketCollectorService;
        basket = new Basket();
    }

    @GetMapping("/book")
    public String addBook(Model model){
        basket.setBooks(basketCollectorService.addBookToBasket().getBooks());
        model.addAttribute("books", basket.getBooks());
        model.addAttribute("jackets", basket.getJackets());
        model.addAttribute("tshirts", basket.getTshirts());
        model.addAttribute("shoes", basket.getShoes());
        return "redirect:/shopping";
    }

    @GetMapping("/tshirt")
    public String addTshirt(Model model){
        basket.setTshirts(basketCollectorService.addTshirtToBasket().getTshirts());
        model.addAttribute("books", basket.getBooks());
        model.addAttribute("jackets", basket.getJackets());
        model.addAttribute("tshirts", basket.getTshirts());
        model.addAttribute("shoes", basket.getShoes());
        return "redirect:/shopping";
    }

    @GetMapping("/jacket")
    public String addJacket(Model model){
        basket.setJackets(basketCollectorService.addJacketToBasket().getJackets());
        model.addAttribute("books", basket.getBooks());
        model.addAttribute("jackets", basket.getJackets());
        model.addAttribute("tshirts", basket.getTshirts());
        model.addAttribute("shoes", basket.getShoes());
        return "redirect:/shopping";
    }

    @GetMapping("/shoe")
    public String addShoe(Model model){
        basket.setShoes(basketCollectorService.addShoeToBasket().getShoes());
        model.addAttribute("books", basket.getBooks());
        model.addAttribute("jackets", basket.getJackets());
        model.addAttribute("tshirts", basket.getTshirts());
        model.addAttribute("shoes", basket.getShoes());
        return "redirect:/shopping";
    }

}
