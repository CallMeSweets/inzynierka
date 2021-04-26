package com.shopapp.receiptsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class BasketReceipt {
    private Map<String, Integer> productCostsMap;
    private Integer totalCost;
    private Double discount;
    private Integer totalDiscount;

    public BasketReceipt() {
    }
}
