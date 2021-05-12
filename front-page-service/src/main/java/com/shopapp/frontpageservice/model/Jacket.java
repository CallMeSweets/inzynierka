package com.shopapp.frontpageservice.model;

import lombok.Data;

@Data
public class Jacket {
    private Long id;
    private Integer price;
    private String mark;
    private String size;
    private String producer;
    private String description;
}
