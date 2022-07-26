package com.company.entity.worker;

import com.company.enums.WorkerStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "worker")
public class WorkerEntity {
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
    private WorkerStatus status;

    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;




}