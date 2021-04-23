package com.shopapp.booksservice.controller;

import com.shopapp.booksservice.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){

        return null;
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){

        return null;
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){

        return null;
    }

    @GetMapping("/{author}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable("author") String author){

        return null;
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestBody Book book){

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") Long id){

        return null;
    }

}
