package com.shopapp.basketservice.controller;

import com.shopapp.basketservice.model.Basket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {


    @GetMapping("/{bookId}")
    public ResponseEntity<Basket> addBookToBasket(@PathVariable("bookId") Long bookId){

        return null;
    }

    @GetMapping("/{shoeId}")
    public ResponseEntity<Basket> addShoeToBasket(@PathVariable("shoeId") Long shoeId){

        return null;
    }

    @GetMapping("/{jacketId}")
    public ResponseEntity<Basket> addJacketToBasket(@PathVariable("jacketId") Long jacketId){

        return null;
    }

    @GetMapping("/{tshirtId}")
    public ResponseEntity<Basket> addTshirtToBasket(@PathVariable("tshirtId") Long tshirtId){

        return null;
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Basket> deleteBookToBasket(@PathVariable("bookId") Long bookId){

        return null;
    }

    @DeleteMapping("/{shoeId}")
    public ResponseEntity<Basket> deleteShoeToBasket(@PathVariable("shoeId") Long shoeId){

        return null;
    }

    @DeleteMapping("/{jacketId}")
    public ResponseEntity<Basket> deleteJacketToBasket(@PathVariable("jacketId") Long jacketId){

        return null;
    }

    @DeleteMapping("/{tshirtId}")
    public ResponseEntity<Basket> deleteTshirtToBasket(@PathVariable("tshirtId") Long tshirtId){

        return null;
    }

}
