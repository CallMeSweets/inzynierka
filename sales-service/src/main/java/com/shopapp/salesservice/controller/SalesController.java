package com.shopapp.salesservice.controller;

import com.shopapp.salesservice.model.Basket;
import com.shopapp.salesservice.model.BasketDiscount;
import com.shopapp.salesservice.prometheus.MetricsService;
import com.shopapp.salesservice.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    private final MetricsService metricsService;
    private final SalesService salesService;

    public SalesController(MetricsService metricsService, SalesService salesService) {
        this.metricsService = metricsService;
        this.salesService = salesService;
    }

    @GetMapping("/status")
    public String status(){
        metricsService.increaseRequestNumber();
        return "OK";
    }

    @PostMapping
    public ResponseEntity<BasketDiscount> getDiscountForBasket(@RequestBody Basket basket){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(salesService.getDiscountForBasket(basket));
    }
}
