package com.shopapp.salesservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BasketDiscount {
    private Basket basket;
    private Integer totalCost;
    private double discount;
    private Integer discountCost;
}
