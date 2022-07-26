package com.company.dto.mail;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SendMailDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String from;
    private String to;
    private String subject;
    private String content;
    private LocalDateTime sendMailDate;
}
