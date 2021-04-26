package com.shopapp.salesservice.service;

import com.shopapp.salesservice.model.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class SalesService {

    public BasketDiscount getDiscountForBasket(Basket basket){
        int totalCost = basket.getBooks().stream().mapToInt(Book::getPrice).sum();
        totalCost += basket.getJackets().stream().mapToInt(Jacket::getPrice).sum();
        totalCost += basket.getShoes().stream().mapToInt(Shoe::getPrice).sum();
        totalCost += basket.getTshirts().stream().mapToInt(Tshirt::getPrice).sum();

        double randomDiscount = ThreadLocalRandom.current().nextDouble(0, 1);
        int discountCost = (int) (totalCost * randomDiscount);

        BasketDiscount basketDiscount = new BasketDiscount(basket, totalCost, randomDiscount, discountCost);

        return basketDiscount;
    }

}
