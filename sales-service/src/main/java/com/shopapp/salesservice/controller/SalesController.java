package com.shopapp.salesservice.controller;

import com.shopapp.salesservice.model.Basket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {


    @PostMapping
    public ResponseEntity<Basket> makeSalesForBasket(@RequestBody Basket basket){

        return null;
    }
}
