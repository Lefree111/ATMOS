package com.company.dto.filial;

import com.company.enums.GroupStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDTO {
    private String id;
    private String name;
    private GroupStatus status;
    private String courseId;
    private LocalDateTime createDate;

}