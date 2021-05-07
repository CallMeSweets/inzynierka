package com.shopapp.shoesservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer price;
    private String mark;
    private String size;
    private String producer;
    private String description;

    public Shoe() {
    }

    public Shoe(Integer price, String mark, String size, String producer, String description) {
        this.price = price;
        this.mark = mark;
        this.size = size;
        this.producer = producer;
        this.description = description;
    }
}
