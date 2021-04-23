package com.shopapp.receiptsservice.model;

import lombok.Data;

@Data
public class Tshirt {
    private Long id;
    private Integer price;
    private String mark;
    private String size;
    private String producer;
    private String description;
}
