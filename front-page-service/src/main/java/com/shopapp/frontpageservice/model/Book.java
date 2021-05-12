package com.shopapp.frontpageservice.model;

import lombok.Data;

@Data
public class Book {
   private Long id;
   private Integer price;
   private String title;
   private String author;
   private String description;

   public Book() {
   }

   public Book(Integer price, String title, String author, String description) {
      this.price = price;
      this.title = title;
      this.author = author;
      this.description = description;
   }
}
