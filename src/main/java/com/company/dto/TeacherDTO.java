package com.company.dto;

import com.company.enums.TeacherStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeacherDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private Integer phone;
    private String email;
    private String expert;
    private Integer sale;
    private TeacherStatus status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
