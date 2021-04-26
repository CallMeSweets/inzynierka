package com.shopapp.booksservice.service;

import com.shopapp.booksservice.dao.BookRepository;
import com.shopapp.booksservice.exception.ElementNotFoundException;
import com.shopapp.booksservice.model.Book;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book){
        return bookRepository.findById(book.getId())
                .map(bookFromDB -> {
                    bookFromDB.setAuthor(book.getAuthor());
                    bookFromDB.setPrice(book.getPrice());
                    bookFromDB.setTitle(book.getTitle());
                    bookFromDB.setDescription(book.getDescription());
                    return bookRepository.save(bookFromDB);
                }).orElseGet(() -> bookRepository.save(book));
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Not found Book with ID: " + id));
    }

    public Book getBookByTitle(String title){
        return bookRepository.findByTitle(title).orElseThrow(() -> new ElementNotFoundException("Not found Book by TITLE: " + title));
    }

    public Book getBookByAuthor(String author){
        return bookRepository.findByAuthor(author).orElseThrow(() -> new ElementNotFoundException("Not found Book by AUTHOR: " + author));
    }

    public Book getBookByPrice(Integer price){
        return bookRepository.findByPrice(price).orElseThrow(() -> new ElementNotFoundException("Not found Book by PRICE: " + price));
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initDB(){
        bookRepository.save(new Book(10, "titleTest3", "authorTest3", "descriptionTest3"));
        bookRepository.save(new Book(11, "titleTest4", "authorTest4", "descriptionTest4"));
    }

}
