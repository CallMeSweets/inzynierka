package com.shopapp.frontpageservice.service;

import com.shopapp.frontpageservice.model.Basket;
import com.shopapp.frontpageservice.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BasketCollectorService {

    private final WebClient.Builder webClientBuilder;
    private final String basketServiceAddress;
    private Basket basket;
    public BasketCollectorService(WebClient.Builder webClientBuilder, @Value("${basket.service.address}") String basketServiceAddress) {
        this.webClientBuilder = webClientBuilder;
        this.basketServiceAddress = basketServiceAddress;
        basket =  new Basket();
    }

    public Basket addBookToBasket(){
        Basket basketBooks = webClientBuilder.build()
                .get()
                .uri(basketServiceAddress + ":8080/api/v1/basket/book" + 1)
                .retrieve()
                .bodyToMono(Basket.class)
                .block();

        if (basketBooks != null) {
            basket.setBooks(basketBooks.getBooks());
        }
        return basket;
    }

    public Basket addShoeToBasket(){
        Basket basketShoes = webClientBuilder.build()
                .get()
                .uri(basketServiceAddress + ":8080/api/v1/basket/shoe/" + 1)
                .retrieve()
                .bodyToMono(Basket.class)
                .block();

        if (basketShoes != null) {
            basket.setShoes(basketShoes.getShoes());
        }
        return basket;
    }

    public Basket addJacketToBasket(){
        Basket basketJackets = webClientBuilder.build()
                .get()
                .uri(basketServiceAddress + ":8080/api/v1/basket/jacket/" + 1)
                .retrieve()
                .bodyToMono(Basket.class)
                .block();

        if (basketJackets != null) {
            basket.setJackets(basketJackets.getJackets());
        }
        return basket;
    }

    public Basket addTshirtToBasket(){
        Basket basketTshirts = webClientBuilder.build()
                .get()
                .uri(basketServiceAddress + ":8080/api/v1/basket/tshirt/" + 1)
                .retrieve()
                .bodyToMono(Basket.class)
                .block();

        if (basketTshirts != null) {
            basket.setTshirts(basketTshirts.getTshirts());
        }
        return basket;
    }

    public Basket getBasket() {
        return basket;
    }
}
