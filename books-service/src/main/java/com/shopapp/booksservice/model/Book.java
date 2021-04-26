package com.shopapp.booksservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private Integer price;

   private String title;

   private String author;

   private String description;

   public Book(Integer price, String title, String author, String description) {
      this.price = price;
      this.title = title;
      this.author = author;
      this.description = description;
   }

   public Book() {

   }
}
