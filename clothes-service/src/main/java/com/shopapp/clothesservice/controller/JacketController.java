package com.shopapp.clothesservice.controller;

import com.shopapp.clothesservice.model.Jacket;
import com.shopapp.clothesservice.service.JacketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jacket")
public class JacketController {

    private final JacketService jacketService;

    public JacketController(JacketService jacketService) {
        this.jacketService = jacketService;
    }

    @GetMapping("/status")
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Jacket> createJacket(@RequestBody Jacket jacket){
        return ResponseEntity.ok(jacketService.createJacket(jacket));
    }

    @PutMapping
    public ResponseEntity<Jacket> updateJacket(@RequestBody Jacket jacket){
        return ResponseEntity.ok(jacketService.updateJacket(jacket));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jacket> getJacketById(@PathVariable("id") Long id){
        return ResponseEntity.ok(jacketService.getJacketById(id));
    }

    @GetMapping("/mark/{mark}")
    public ResponseEntity<Jacket> getJacketByMark(@PathVariable("mark") String mark){
        return ResponseEntity.ok(jacketService.getJacketByMark(mark));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<Jacket> getJacketBySize(@PathVariable("size") String size){
        return ResponseEntity.ok(jacketService.getJacketBySize(size));
    }

    @GetMapping("/producer/{producer}")
    public ResponseEntity<Jacket> getJacketByProducer(@PathVariable("producer") String producer){
        return ResponseEntity.ok(jacketService.getJacketByProducer(producer));
    }

    @DeleteMapping
    public ResponseEntity deleteJacket(@RequestBody Jacket jacket){
        jacketService.deleteJacket(jacket);
        return ResponseEntity.ok("Jacket deleted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJacketById(@PathVariable("id") Long id){
        jacketService.deleteJacketById(id);
        return ResponseEntity.ok("Jacket deleted");
    }

}
