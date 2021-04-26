package com.shopapp.booksservice.dao;

import com.shopapp.booksservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByPrice(Integer price);
    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthor(String author);

}
