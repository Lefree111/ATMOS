package com.company.dto;

import com.company.entity.BranchEntity;
import com.company.enums.StudentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    private String id;
    private String name;
    private String surname;
    private String username;
    private Integer phone;
    private BranchEntity branch_id;
    private String email;
    private String password;
    private Integer balance;
    private StudentStatus status;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}