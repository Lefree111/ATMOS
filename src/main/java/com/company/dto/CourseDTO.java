package com.company.dto;

import com.company.enums.CourseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {
    private String id;
    private String name;
    private Integer balance;
    private CourseStatus status;
    private LocalDateTime createData;
}