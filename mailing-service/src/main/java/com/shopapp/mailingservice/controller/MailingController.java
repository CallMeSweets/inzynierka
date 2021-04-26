package com.shopapp.mailingservice.controller;

import com.shopapp.mailingservice.model.EmailMessage;
import com.shopapp.mailingservice.service.MailingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
public class MailingController {

    private final MailingService mailingservice;

    public MailingController(MailingService mailingservice) {
        this.mailingservice = mailingservice;
    }

    @PostMapping
    public void sendEmailMessage(@RequestBody EmailMessage emailMessage){
        mailingservice.sendEmailMessage(emailMessage);
    }

}
