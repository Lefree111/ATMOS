package com.company.dto;

import com.company.entity.BranchEntity;
import com.company.enums.WorkerStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkerDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private Integer phone;
    private BranchEntity branch_id;
    private String email;
    private String expert;
    private Integer sale;
    private WorkerStatus status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
