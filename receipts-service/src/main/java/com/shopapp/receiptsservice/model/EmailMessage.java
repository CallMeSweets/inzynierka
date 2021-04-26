package com.shopapp.receiptsservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailMessage {

    private String message;
    private String title;
    private String fromWho;
    private String toWho;

}
