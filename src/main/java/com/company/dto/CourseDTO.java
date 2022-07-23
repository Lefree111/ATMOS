package com.company.dto;

import com.company.enums.CourseStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseDTO {
    private String id;
    private String name;
    private Integer balance;
    private CourseStatus status;
    private LocalDateTime createData;
}