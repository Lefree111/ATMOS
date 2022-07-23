package com.company.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SendMailDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private LocalDateTime sendMailDate;
}
