package com.shopapp.frontpageservice.controller;

import com.shopapp.frontpageservice.model.Basket;
import com.shopapp.frontpageservice.service.BasketCollectorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/shopping/api/v1/front")
public class FrontServiceController {

    private final BasketCollectorService basketCollectorService;
    private Basket basket;

    public FrontServiceController(BasketCollectorService basketCollectorService) {
        this.basketCollectorService = basketCollectorService;
        basket = new Basket();
    }

    @GetMapping("/receipt")
    public String getReceipt(Model model){
        basketCollectorService.getBasketReceipt();
        model.addAttribute("books", basket.getBooks());
        model.addAttribute("jackets", basket.getJackets());
        model.addAttribute("tshirts", basket.getTshirts());
        model.addAttribute("shoes", basket.getShoes());
        return "redirect:/shopping";
    }

    @GetMapping("/discount")
    public String getDiscount(Model model){
        basketCollectorService.getBasketDiscount();
        model.addAttribute("books", basket.getBooks());
        model.addAttribute("jackets", basket.getJackets());
        model.addAttribute("tshirts", basket.getTshirts());
        model.addAttribute("shoes", basket.getShoes());
        return "redirect:/shopping";
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

    @GetMapping("/clear")
    public String clear(Model model){
        basketCollectorService.clearBasket();
        basket.setShoes(new ArrayList<>());
        basket.setBooks(new ArrayList<>());
        basket.setTshirts(new ArrayList<>());
        basket.setJackets(new ArrayList<>());
        model.addAttribute("books", basket.getBooks());
        model.addAttribute("jackets", basket.getJackets());
        model.addAttribute("tshirts", basket.getTshirts());
        model.addAttribute("shoes", basket.getShoes());
        return "redirect:/shopping";
    }

}
