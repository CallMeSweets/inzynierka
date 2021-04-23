package com.shopapp.booksservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Integer price;

   private String title;

   private String author;

   private String description;
}
