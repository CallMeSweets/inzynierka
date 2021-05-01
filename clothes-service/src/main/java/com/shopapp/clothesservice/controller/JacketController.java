package com.shopapp.clothesservice.controller;

import com.shopapp.clothesservice.model.Jacket;
import com.shopapp.clothesservice.prometheus.MetricsService;
import com.shopapp.clothesservice.service.JacketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jacket")
public class JacketController {

    private final MetricsService metricsService;
    private final JacketService jacketService;

    public JacketController(MetricsService metricsService, JacketService jacketService) {
        this.metricsService = metricsService;
        this.jacketService = jacketService;
    }

    @GetMapping("/status")
    public String status(){
        metricsService.increaseRequestNumber();
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Jacket> createJacket(@RequestBody Jacket jacket){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(jacketService.createJacket(jacket));
    }

    @PutMapping
    public ResponseEntity<Jacket> updateJacket(@RequestBody Jacket jacket){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(jacketService.updateJacket(jacket));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jacket> getJacketById(@PathVariable("id") Long id){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(jacketService.getJacketById(id));
    }

    @GetMapping("/mark/{mark}")
    public ResponseEntity<Jacket> getJacketByMark(@PathVariable("mark") String mark){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(jacketService.getJacketByMark(mark));
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<Jacket> getJacketBySize(@PathVariable("size") String size){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(jacketService.getJacketBySize(size));
    }

    @GetMapping("/producer/{producer}")
    public ResponseEntity<Jacket> getJacketByProducer(@PathVariable("producer") String producer){
        metricsService.increaseRequestNumber();
        return ResponseEntity.ok(jacketService.getJacketByProducer(producer));
    }

    @DeleteMapping
    public ResponseEntity deleteJacket(@RequestBody Jacket jacket){
        metricsService.increaseRequestNumber();
        jacketService.deleteJacket(jacket);
        return ResponseEntity.ok("Jacket deleted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJacketById(@PathVariable("id") Long id){
        metricsService.increaseRequestNumber();
        jacketService.deleteJacketById(id);
        return ResponseEntity.ok("Jacket deleted");
    }

}
