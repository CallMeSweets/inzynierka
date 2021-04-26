package com.shopapp.salesservice.controller;

import com.shopapp.salesservice.model.Basket;
import com.shopapp.salesservice.model.BasketDiscount;
import com.shopapp.salesservice.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    private SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping
    public ResponseEntity<BasketDiscount> getDiscountForBasket(@RequestBody Basket basket){
        return ResponseEntity.ok(salesService.getDiscountForBasket(basket));
    }
}
