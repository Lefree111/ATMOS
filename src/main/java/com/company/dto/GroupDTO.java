package com.company.dto;

import com.company.enums.GroupStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupDTO {
    private String id;
    private String name;
    private String course_id;
    private String worker_id;
    private GroupStatus status;
    private Integer student_count;
    private LocalDateTime createData;
}