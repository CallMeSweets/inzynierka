package com.shopapp.shoesservice.controller;

import com.shopapp.shoesservice.model.Shoe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shoe")
public class ShoeController {

    @PostMapping
    public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe){

        return null;
    }

    @PutMapping
    public ResponseEntity<Shoe> updateShoe(@RequestBody Shoe shoe){

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shoe> getShoeById(@PathVariable("id") Long id){

        return null;
    }

    @GetMapping("/{mark}")
    public ResponseEntity<Shoe> getShoeByMark(@PathVariable("mark") String mark){

        return null;
    }

    @GetMapping("/{size}")
    public ResponseEntity<Shoe> getShoeBySize(@PathVariable("size") String size){

        return null;
    }

    @GetMapping("/{producer}")
    public ResponseEntity<Shoe> getShoeByProducer(@PathVariable("producer") String producer){

        return null;
    }

    @DeleteMapping
    public ResponseEntity deleteShoe(@RequestBody Shoe shoe){

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteShoeById(@PathVariable("id") Long id){

        return null;
    }

}
