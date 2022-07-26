package com.company.entity.filial;

import com.company.enums.GroupStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "groups_table")
public class GroupEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;
    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private GroupStatus status;

    @Column
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",insertable = false,updatable = false)
    private CourseEntity course;
    @Column(name = "course_id")
    private String course_id;


}