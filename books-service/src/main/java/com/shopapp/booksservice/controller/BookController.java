package com.shopapp.booksservice.controller;

import com.shopapp.booksservice.model.Book;
import com.shopapp.booksservice.prometheus.MetricsService;
import com.shopapp.booksservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final MetricsService metricsService;
    private final BookService bookService;

    public BookController(MetricsService metricsService, BookService bookService) {
        this.metricsService = metricsService;
        this.bookService = bookService;
    }

    @GetMapping("/status")
    public String status(){
        metricsService.increaseRequestNumber();
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(bookService.getBookByTitle(title));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable("author") String author){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(bookService.getBookByAuthor(author));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<Book> getBookByPrice(@PathVariable("price") Integer price){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(bookService.getBookByPrice(price));
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestBody Book book){
        metricsService.increaseRequestNumber();
        bookService.deleteBook(book);
        return ResponseEntity.ok("Book deleted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") Long id){
        metricsService.increaseRequestNumber();
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book deleted");
    }

}
