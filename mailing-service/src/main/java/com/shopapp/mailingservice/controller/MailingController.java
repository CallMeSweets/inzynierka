package com.shopapp.mailingservice.controller;

import com.shopapp.mailingservice.model.EmailMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
public class MailingController {

    @PostMapping
    public ResponseEntity<EmailMessage> sendEmailMessage(@RequestBody EmailMessage emailMessage){

        return null;
    }

}
