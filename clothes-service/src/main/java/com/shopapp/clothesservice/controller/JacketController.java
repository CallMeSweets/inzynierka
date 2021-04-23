package com.shopapp.clothesservice.controller;

import com.shopapp.clothesservice.model.Jacket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jacket")
public class JacketController {

    @PostMapping
    public ResponseEntity<Jacket> createJacket(@RequestBody Jacket jacket){

        return null;
    }

    @PutMapping
    public ResponseEntity<Jacket> updateJacket(@RequestBody Jacket jacket){

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jacket> getJacketById(@PathVariable("id") Long id){

        return null;
    }

    @GetMapping("/{mark}")
    public ResponseEntity<Jacket> getJacketByMark(@PathVariable("mark") String mark){

        return null;
    }

    @GetMapping("/{size}")
    public ResponseEntity<Jacket> getJacketBySize(@PathVariable("size") String size){

        return null;
    }

    @GetMapping("/{producer}")
    public ResponseEntity<Jacket> getJacketByProducer(@PathVariable("producer") String producer){

        return null;
    }

    @DeleteMapping
    public ResponseEntity deleteJacket(@RequestBody Jacket jacket){

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJacketById(@PathVariable("id") Long id){

        return null;
    }

}
