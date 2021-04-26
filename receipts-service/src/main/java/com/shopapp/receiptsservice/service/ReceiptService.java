package com.shopapp.receiptsservice.service;

import com.shopapp.receiptsservice.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReceiptService {

    private final WebClient.Builder webClientBuilder;

    public ReceiptService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public BasketReceipt getReceiptForBasket(Basket basket){
        Map<String, Integer> productCostsMap = new HashMap<>();

        basket.getBooks().forEach(book -> {
            productCostsMap.put(book.getTitle() + " " + book.getAuthor(), book.getPrice());
        });

        basket.getShoes().forEach(shoe -> {
            productCostsMap.put(shoe.getProducer() + " " + shoe.getMark(), shoe.getPrice());
        });

        basket.getJackets().forEach(jacket -> {
            productCostsMap.put(jacket.getProducer() + " " + jacket.getMark(), jacket.getPrice());
        });

        basket.getTshirts().forEach(tshirt -> {
            productCostsMap.put(tshirt.getProducer() + " " + tshirt.getMark(), tshirt.getPrice());
        });

        BasketDiscount basketDiscount = getDiscountForBasket(basket);
        return new BasketReceipt(productCostsMap, basketDiscount.getTotalCost(), basketDiscount.getDiscount(), basketDiscount.getDiscountCost());
    }

    public BasketDiscount getDiscountForBasket(Basket basket){
        BasketDiscount basketDiscount = webClientBuilder.build()
                .post()
                .uri("localhost:8075/api/v1/sales")
                .body(Mono.just(basket), Basket.class)
                .retrieve()
                .bodyToMono(BasketDiscount.class)
                .block();

        return basketDiscount;
    }

    public void sendEmailMessageForBasket(Basket basket) {
                webClientBuilder.build()
                .post()
                .uri("localhost:8074/api/v1/email")
                .body(Mono.just(prepareEmailMessage(basket)), EmailMessage.class)
                .retrieve()
                .bodyToMono(BasketDiscount.class)
                .block();
    }

    private EmailMessage prepareEmailMessage(Basket basket){
        String message = convertProductCostMap(getReceiptForBasket(basket).getProductCostsMap());

        EmailMessage emailMessage = EmailMessage.builder()
                .fromWho("southpowercontact@gmail.com")
                .toWho("grz3lak1997@gmail.com")
                .title("Receipt")
                .message(message)
                .build();

        return emailMessage;
    }

    private String convertProductCostMap(Map<String, Integer> map) {
        String productCost = map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return productCost;
    }
}
