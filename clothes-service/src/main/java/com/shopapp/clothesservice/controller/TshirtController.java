package com.shopapp.clothesservice.controller;

import com.shopapp.clothesservice.model.Tshirt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tshirt")
public class TshirtController {

    @PostMapping
    public ResponseEntity<Tshirt> createTshirt(@RequestBody Tshirt tshirt){

        return null;
    }

    @PutMapping
    public ResponseEntity<Tshirt> updateTshirt(@RequestBody Tshirt tshirt){

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tshirt> getTshirtById(@PathVariable("id") Long id){

        return null;
    }

    @GetMapping("/{producer}")
    public ResponseEntity<Tshirt> getTshirtByProducer(@PathVariable("producer") String producer){

        return null;
    }

    @GetMapping("/{mark}")
    public ResponseEntity<Tshirt> getTshirtByMark(@PathVariable("mark") String mark){

        return null;
    }

    @GetMapping("/{size}")
    public ResponseEntity<Tshirt> getTshirtBySize(@PathVariable("size") String size){

        return null;
    }

    @DeleteMapping
    public ResponseEntity deleteTshirt(@RequestBody Tshirt tshirt){

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTshirtById(@PathVariable("id") Long id){

        return null;
    }

}
