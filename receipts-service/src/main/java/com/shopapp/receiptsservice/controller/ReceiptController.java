package com.shopapp.receiptsservice.controller;

import com.shopapp.receiptsservice.model.Basket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/receipt")
public class ReceiptController {


    @PostMapping
    public ResponseEntity<Basket> makeReceiptForBasket(@RequestBody Basket basket){

        return null;
    }
}
