package com.shopapp.accountcreationservice.controller;

import com.shopapp.accountcreationservice.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class RegisterController {

    @GetMapping("/status")
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){

        return null;
    }

    @PutMapping
    public ResponseEntity<Account> updateAccount(@RequestBody Account account){

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id){

        return null;
    }

    @GetMapping("/{email}")
    public ResponseEntity<Account> getAccountByEmail(@PathVariable("email") String email){

        return null;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Account> getAccountByUsername(@PathVariable("username") String username){

        return null;
    }

    @DeleteMapping
    public ResponseEntity deleteAccount(@RequestBody Account account){

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccountById(@PathVariable("id") Long id){

        return null;
    }

}
