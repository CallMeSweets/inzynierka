package com.shopapp.clothesservice.controller;

import com.shopapp.clothesservice.model.Tshirt;
import com.shopapp.clothesservice.service.TshirtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tshirt")
public class TshirtController {
    
    private final TshirtService tshirtService;

    public TshirtController(TshirtService tshirtService) {
        this.tshirtService = tshirtService;
    }

    @GetMapping("/status")
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Tshirt> createTshirt(@RequestBody Tshirt tshirt){
        return ResponseEntity.ok(tshirtService.createTshirt(tshirt));
    }

    @PutMapping
    public ResponseEntity<Tshirt> updateTshirt(@RequestBody Tshirt tshirt){
        return ResponseEntity.ok(tshirtService.updateTshirt(tshirt));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tshirt> getTshirtById(@PathVariable("id") Long id){
        return ResponseEntity.ok(tshirtService.getTshirtById(id));
    }

    @GetMapping("/producer/{producer}")
    public ResponseEntity<Tshirt> getTshirtByProducer(@PathVariable("producer") String producer){
        return ResponseEntity.ok(tshirtService.getTshirtByProducer(producer));
    }

    @GetMapping("/mark/{mark}")
    public ResponseEntity<Tshirt> getTshirtByMark(@PathVariable("mark") String mark){
        return ResponseEntity.ok(tshirtService.getTshirtByMark(mark));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<Tshirt> getTshirtBySize(@PathVariable("size") String size){
        return ResponseEntity.ok(tshirtService.getTshirtBySize(size));
    }

    @DeleteMapping
    public ResponseEntity deleteTshirt(@RequestBody Tshirt tshirt){
        tshirtService.deleteTshirt(tshirt);
        return ResponseEntity.ok("Tshirt deleted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTshirtById(@PathVariable("id") Long id){
        tshirtService.deleteTshirtById(id);
        return ResponseEntity.ok("Tshirt deleted");
    }

}
