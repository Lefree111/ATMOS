package com.company.entity;

import com.company.enums.FilialStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "filial")
public class FilialEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private FilialStatus status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student",unique = true,updatable = false)
    private StudentEntity student;
    @Column(name = "student")
    private Integer student_count;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker",unique = true,updatable = false)
    private WorkerEntity worker;
    @Column(name = "worker")
    private Integer worker_count;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;

}