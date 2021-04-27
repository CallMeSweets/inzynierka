package com.shopapp.shoesservice.controller;

import com.shopapp.shoesservice.model.Shoe;
import com.shopapp.shoesservice.service.ShoeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shoe")
public class ShoeController {

    private final ShoeService shoeService;

    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping("/status")
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe){
        return ResponseEntity.ok(shoeService.createShoe(shoe));
    }

    @PutMapping
    public ResponseEntity<Shoe> updateShoe(@RequestBody Shoe shoe){
        return ResponseEntity.ok(shoeService.updateShoe(shoe));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shoe> getShoeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(shoeService.getShoeById(id));
    }

    @GetMapping("/mark/{mark}")
    public ResponseEntity<Shoe> getShoeByMark(@PathVariable("mark") String mark){
        return ResponseEntity.ok(shoeService.getShoeByMark(mark));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<Shoe> getShoeBySize(@PathVariable("size") String size){
        return ResponseEntity.ok(shoeService.getShoeBySize(size));
    }

    @GetMapping("/producer/{producer}")
    public ResponseEntity<Shoe> getShoeByProducer(@PathVariable("producer") String producer){
        return ResponseEntity.ok(shoeService.getShoeByProducer(producer));
    }

    @DeleteMapping
    public ResponseEntity deleteShoe(@RequestBody Shoe shoe){
        shoeService.deleteShoe(shoe);
        return ResponseEntity.ok("Shoe deleted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteShoeById(@PathVariable("id") Long id){
        shoeService.deleteShoeById(id);
        return ResponseEntity.ok("Shoe deleted");
    }

}
