package com.shopapp.frontpageservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@AllArgsConstructor
@ToString
public class BasketReceipt {
    private Map<String, Integer> productCostsMap;
    private Integer totalCost;
    private Double discount;
    private Integer totalDiscount;

    public BasketReceipt() {
    }
}
