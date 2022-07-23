package com.company.dto;

import com.company.enums.FilialStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilialDTO {
    private String id;
    private String name;
    private FilialStatus status;
    private Integer student_count;
    private Integer worker_count;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
