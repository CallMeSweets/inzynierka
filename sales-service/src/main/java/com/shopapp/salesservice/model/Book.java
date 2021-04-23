package com.shopapp.salesservice.model;

import lombok.Data;

@Data
public class Book {
   private Long id;
   private Integer price;
   private String title;
   private String author;
   private String description;
}
