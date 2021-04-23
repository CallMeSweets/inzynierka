package com.shopapp.basketservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Basket {

    private List<Book> books;
    private List<Jacket> jackets;
    private List<Shoe> shoes;
    private List<Tshirt> tshirts;

}
