package com.shopapp.receiptsservice.controller;

import com.shopapp.receiptsservice.model.*;
import com.shopapp.receiptsservice.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping
    public ResponseEntity<BasketReceipt> makeReceiptForBasket(@RequestBody Basket basket){
        return ResponseEntity.ok(receiptService.getReceiptForBasket(basket));
    }

    @PostMapping("/email")
    public ResponseEntity sendEmailMessageForBasket(@RequestBody Basket basket){
        receiptService.sendEmailMessageForBasket(basket);
        return ResponseEntity.ok("Email was send!");
    }
}
