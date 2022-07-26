package com.company.entity;

import com.company.enums.GroupStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private CourseEntity kurs;
    @Column(name = "course_id")
    private String kurs_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wor_id", insertable = false, updatable = false)
    private WorkerEntity wor;
    @Column(name = "wor_id")
    private String wor_id;

    @Column
    @Enumerated(EnumType.STRING)
    private GroupStatus status;


}