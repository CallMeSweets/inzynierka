package com.shopapp.receiptsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class BasketDiscount {
    private Basket basket;
    private Integer totalCost;
    private double discount;
    private Integer discountCost;

    public BasketDiscount() {
    }
}
