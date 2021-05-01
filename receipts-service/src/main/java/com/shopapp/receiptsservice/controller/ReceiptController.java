package com.shopapp.receiptsservice.controller;

import com.shopapp.receiptsservice.model.*;
import com.shopapp.receiptsservice.prometheus.MetricsService;
import com.shopapp.receiptsservice.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/receipt")
public class ReceiptController {

    private final MetricsService metricsService;
    private final ReceiptService receiptService;

    public ReceiptController(MetricsService metricsService, ReceiptService receiptService) {
        this.metricsService = metricsService;
        this.receiptService = receiptService;
    }

    @GetMapping("/status")
    public String status(){
        metricsService.increaseRequestNumber();
        return "OK";
    }

    @PostMapping
    public ResponseEntity<BasketReceipt> makeReceiptForBasket(@RequestBody Basket basket){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(receiptService.getReceiptForBasket(basket));
    }

    @PostMapping("/email")
    public ResponseEntity sendEmailMessageForBasket(@RequestBody Basket basket){
        metricsService.increaseRequestNumber();
        receiptService.sendEmailMessageForBasket(basket);
        return ResponseEntity.ok("Email was send!");
    }
}
