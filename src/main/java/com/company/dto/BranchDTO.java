package com.company.dto;

import com.company.entity.CourseEntity;
import com.company.enums.FilialStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchDTO {
    private String id;
    private String name;
    private CourseEntity course;
    private FilialStatus status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
