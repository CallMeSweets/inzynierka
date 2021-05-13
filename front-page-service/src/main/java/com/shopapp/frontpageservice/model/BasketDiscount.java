package com.shopapp.frontpageservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class BasketDiscount {
    private Basket basket;
    private Integer totalCost;
    private double discount;
    private Integer discountCost;

    public BasketDiscount() {
    }
}
