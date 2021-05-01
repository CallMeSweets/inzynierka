package com.shopapp.mailingservice.controller;

import com.shopapp.mailingservice.model.EmailMessage;
import com.shopapp.mailingservice.prometheus.MetricsService;
import com.shopapp.mailingservice.service.MailingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
public class MailingController {

    Logger logger = LoggerFactory.getLogger(MailingController.class);

    private final MailingService mailingservice;
    private final MetricsService metricsService;

    public MailingController(MailingService mailingservice, MetricsService metricsService) {
        this.mailingservice = mailingservice;
        this.metricsService = metricsService;
    }

    @GetMapping("/status")
    public String status(){
        logger.info("METHOD: status");
        metricsService.increaseRequestNumber();
        return "OK";
    }

    @PostMapping
    public void sendEmailMessage(@RequestBody EmailMessage emailMessage){
        logger.info("METHOD: sendEmailMessage");
        metricsService.increaseRequestNumber();
        mailingservice.sendEmailMessage(emailMessage);
    }

}
