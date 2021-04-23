package com.shopapp.mailingservice.model;

import lombok.Data;

@Data
public class EmailMessage {

    private String message;
    private String title;
    private String fromWho;
    private String toWho;

}
