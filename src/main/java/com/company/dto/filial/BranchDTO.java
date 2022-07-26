package com.company.dto.filial;

import com.company.enums.FilialStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchDTO {
    private String id;
    private String name;
    private FilialStatus status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
