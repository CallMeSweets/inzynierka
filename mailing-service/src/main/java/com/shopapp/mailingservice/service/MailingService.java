package com.shopapp.mailingservice.service;

import com.shopapp.mailingservice.model.EmailMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingService{

    private final JavaMailSender javaMailSender;

    public MailingService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailMessage(EmailMessage emailMessage) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailMessage.getToWho());
        mail.setFrom(emailMessage.getFromWho());
        mail.setSubject(emailMessage.getTitle());
        mail.setText(emailMessage.getMessage());

        javaMailSender.send(mail);
    }

}
