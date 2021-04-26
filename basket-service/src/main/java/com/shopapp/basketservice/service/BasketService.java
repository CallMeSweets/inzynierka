package com.shopapp.basketservice.service;

import com.shopapp.basketservice.exception.BasketNoInitializeException;
import com.shopapp.basketservice.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@Service
public class BasketService {

    private final WebClient.Builder webClientBuilder;
    private final String receiptServiceAddress;
    private final String shoesServiceAddress;
    private final String bookServiceAddress;
    private final String jacketTshirtServiceAddress;
    private final String salesServiceAddress;

    private Basket basket;

    public BasketService(WebClient.Builder webClientBuilder,
                         @Value("${receipt.service.address}") String receiptServiceAddress,
                         @Value("${shoes.service.address}") String shoesServiceAddress,
                         @Value("${book.service.address}") String bookServiceAddress,
                         @Value("${jacket.tshrit.service.address}") String jacketTshirtServiceAddress,
                         @Value("${sales.service.address}") String salesServiceAddress) {
        this.webClientBuilder = webClientBuilder;
        this.receiptServiceAddress = receiptServiceAddress;
        this.shoesServiceAddress = shoesServiceAddress;
        this.bookServiceAddress = bookServiceAddress;
        this.jacketTshirtServiceAddress = jacketTshirtServiceAddress;
        this.salesServiceAddress = salesServiceAddress;
    }

    public Basket getBasket(){
        if(basket == null){
            throw new BasketNoInitializeException("Basket not initialize and not elements inside");
        }
        return basket;
    }

    public Basket addBookToBasket(@PathVariable("bookId") Long bookId){
        if(basket == null){
            basket = new Basket();
        }
        Book book = webClientBuilder.build()
                    .get()
                    .uri(bookServiceAddress + ":8080/api/v1/book/" + bookId)
                    .retrieve()
                    .bodyToMono(Book.class)
                    .block();

        basket.addBook(book);
        return basket;
    }

    public Basket addShoeToBasket(@PathVariable("shoeId") Long shoeId){
        if(basket == null){
            basket = new Basket();
        }
        Shoe shoe = webClientBuilder.build()
                .get()
                .uri(shoesServiceAddress + ":8080/api/v1/shoe/" + shoeId)
                .retrieve()
                .bodyToMono(Shoe.class)
                .block();

        basket.addShoe(shoe);
        return basket;
    }

    public Basket addJacketToBasket(@PathVariable("jacketId") Long jacketId){
        if(basket == null){
            basket = new Basket();
        }
        Jacket jacket = webClientBuilder.build()
                .get()
                .uri(jacketTshirtServiceAddress + ":8080/api/v1/jacket/" + jacketId)
                .retrieve()
                .bodyToMono(Jacket.class)
                .block();

        basket.addJacket(jacket);
        return basket;
    }

    public Basket addTshirtToBasket(@PathVariable("tshirtId") Long tshirtId){
        if(basket == null){
            basket = new Basket();
        }
        Tshirt tshirt = webClientBuilder.build()
                .get()
                .uri(jacketTshirtServiceAddress + ":8080/api/v1/tshirt/" + tshirtId)
                .retrieve()
                .bodyToMono(Tshirt.class)
                .block();

        basket.addTshirt(tshirt);
        return basket;
    }

    public Basket deleteBookFromBasket(@PathVariable("bookId") Long bookId){
        if(basket == null){
            throw new NoSuchElementException("Not found element BOOK in BASKET with ID: " + bookId);
        }
        basket.deleteBook(bookId);
        return basket;
    }

    public Basket deleteShoeFromBasket(@PathVariable("shoeId") Long shoeId){
        if(basket == null){
            throw new NoSuchElementException("Not found element SHOE in BASKET with ID: " + shoeId);
        }
        basket.deleteShoe(shoeId);
        return basket;
    }

    public Basket deleteJacketFromBasket(@PathVariable("jacketId") Long jacketId){
        if(basket == null){
            throw new NoSuchElementException("Not found element JACKET in BASKET with ID: " + jacketId);
        }
        basket.deleteJacket(jacketId);
        return basket;
    }

    public Basket deleteTshirtFromBasket(@PathVariable("tshirtId") Long tshirtId){
        if(basket == null){
            throw new NoSuchElementException("Not found element TSHIRT in BASKET with ID: " + tshirtId);
        }
        basket.deleteTshirt(tshirtId);
        return basket;
    }

    public BasketDiscount getBasketWithDiscount(){
        if(basket == null){
            throw new BasketNoInitializeException("Basket not initialize and not elements inside");
        }
        BasketDiscount basketDiscount = webClientBuilder.build()
                .post()
                .uri(salesServiceAddress + ":8080/api/v1/sales")
                .body(Mono.just(basket), Basket.class)
                .retrieve()
                .bodyToMono(BasketDiscount.class)
                .block();

        return basketDiscount;
    }

    public BasketReceipt getReceiptForBasket(){
        if(basket == null){
            throw new BasketNoInitializeException("Basket not initialize and not elements inside");
        }
        BasketReceipt basketReceipt = webClientBuilder.build()
                .post()
                .uri(receiptServiceAddress + ":8080/api/v1/receipt")
                .body(Mono.just(basket), Basket.class)
                .retrieve()
                .bodyToMono(BasketReceipt.class)
                .block();

        webClientBuilder.build()
                .post()
                .uri(receiptServiceAddress + ":8080/api/v1/receipt/email")
                .body(Mono.just(basket), Basket.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return basketReceipt;
    }

}
