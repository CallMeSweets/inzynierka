package com.shopapp.mailingservice.service;
import com.shopapp.mailingservice.model.EmailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingService{

    Logger logger = LoggerFactory.getLogger(MailingService.class);

    private final JavaMailSender javaMailSender;

    public MailingService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailMessage(EmailMessage emailMessage) throws MailException {
        logger.info("METHOD: sendEmailMessage");
        logger.info("EMAIL_MESSAGE: emailMessage");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailMessage.getToWho());
        mail.setFrom(emailMessage.getFromWho());
        mail.setSubject(emailMessage.getTitle());
        mail.setText(emailMessage.getMessage());

        logger.info("sending message");
        javaMailSender.send(mail);
        logger.info("message send");
    }

}
