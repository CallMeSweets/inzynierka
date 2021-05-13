package com.shopapp.basketservice.controller;

import com.shopapp.basketservice.model.*;
import com.shopapp.basketservice.prometheus.MetricsService;
import com.shopapp.basketservice.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {

    private final MetricsService metricsService;
    private final BasketService basketService;

    public BasketController(MetricsService metricsService, BasketService basketService) {
        this.metricsService = metricsService;
        this.basketService = basketService;
    }

    @GetMapping("/status")
    public String status(){
        metricsService.increaseRequestNumber();
        return "OK";
    }

    @GetMapping
    public ResponseEntity<Basket> getBasket(){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.getBasket());
    }

    @GetMapping("/clear")
    public String clearBasket(){
        metricsService.increaseRequestNumber();
        basketService.clearBasket();
        return "OK";
    }

    @GetMapping("/discount")
    public ResponseEntity<BasketDiscount> getBasketWithDiscount(){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.getBasketWithDiscount());
    }

    @GetMapping("/receipt")
    public ResponseEntity<BasketReceipt> getReceiptForBasket(){
        return ResponseEntity.ok(basketService.getReceiptForBasket());
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Basket> addBookToBasket(@PathVariable("bookId") Long bookId){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.addBookToBasket(bookId));
    }

    @GetMapping("/shoe/{shoeId}")
    public ResponseEntity<Basket> addShoeToBasket(@PathVariable("shoeId") Long shoeId){
        return ResponseEntity.ok(basketService.addShoeToBasket(shoeId));
    }

    @GetMapping("/jacket/{jacketId}")
    public ResponseEntity<Basket> addJacketToBasket(@PathVariable("jacketId") Long jacketId){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.addJacketToBasket(jacketId));
    }

    @GetMapping("/tshirt/{tshirtId}")
    public ResponseEntity<Basket> addTshirtToBasket(@PathVariable("tshirtId") Long tshirtId){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.addTshirtToBasket(tshirtId));
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Basket> deleteBookFromBasket(@PathVariable("bookId") Long bookId){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.deleteBookFromBasket(bookId));
    }

    @DeleteMapping("/shoe/{shoeId}")
    public ResponseEntity<Basket> deleteShoeFromBasket(@PathVariable("shoeId") Long shoeId){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.deleteShoeFromBasket(shoeId));
    }

    @DeleteMapping("/jacket/{jacketId}")
    public ResponseEntity<Basket> deleteJacketFromBasket(@PathVariable("jacketId") Long jacketId){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.deleteJacketFromBasket(jacketId));
    }

    @DeleteMapping("/tshirt/{tshirtId}")
    public ResponseEntity<Basket> deleteTshirtFromBasket(@PathVariable("tshirtId") Long tshirtId){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(basketService.deleteTshirtFromBasket(tshirtId));
    }

}
