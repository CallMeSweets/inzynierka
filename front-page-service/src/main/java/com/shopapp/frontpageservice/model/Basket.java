package com.shopapp.frontpageservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Basket {

    private List<Book> books;
    private List<Jacket> jackets;
    private List<Shoe> shoes;
    private List<Tshirt> tshirts;

    public Basket() {
        this.books = new ArrayList<>();
        this.jackets = new ArrayList<>();
        this.shoes = new ArrayList<>();
        this.tshirts = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void deleteBook(Long id){
        if(books.isEmpty()){
            return;
        }

        books.removeIf(book -> book.getId() == id);
    }

    public void addJacket(Jacket jacket){
        jackets.add(jacket);
    }

    public void deleteJacket(Long id){
        if(jackets.isEmpty()){
            return;
        }

        jackets.removeIf(jacket -> jacket.getId() == id);
    }

    public void addShoe(Shoe shoe){
        shoes.add(shoe);
    }

    public void deleteShoe(Long id){
        if(shoes.isEmpty()){
            return;
        }

        shoes.removeIf(shoe -> shoe.getId() == id);
    }

    public void addTshirt(Tshirt tshirt){
        tshirts.add(tshirt);
    }

    public void deleteTshirt(Long id){
        if(tshirts.isEmpty()){
            return;
        }

        tshirts.removeIf(tshirt -> tshirt.getId() == id);
    }
}
