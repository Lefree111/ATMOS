package com.company.entity.student;

import com.company.entity.filial.GroupEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table
public class Student_Group_Entity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",insertable = false,updatable = false)
    private StudentEntity student;
    @Column(name = "student_id")
    private String student_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id",insertable = false,updatable = false)
    private GroupEntity group;
    @Column(name = "group_id")
    private String group_id;
}