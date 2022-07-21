package com.company.entity;

import com.company.enums.StudentStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private Integer phone;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "expert")
    private String expert;
    @Column
    private Integer sale;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StudentStatus status;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;




}