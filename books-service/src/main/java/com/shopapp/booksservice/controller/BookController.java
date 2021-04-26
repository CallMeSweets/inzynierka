package com.shopapp.booksservice.controller;

import com.shopapp.booksservice.model.Book;
import com.shopapp.booksservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) throws InterruptedException {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){
        return ResponseEntity.ok(bookService.getBookByTitle(title));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable("author") String author){
        return ResponseEntity.ok(bookService.getBookByAuthor(author));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<Book> getBookByPrice(@PathVariable("price") Integer price){
        return ResponseEntity.ok(bookService.getBookByPrice(price));
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestBody Book book){
        bookService.deleteBook(book);
        return ResponseEntity.ok("Book deleted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book deleted");
    }

}
