package com.company.entity.filial;

import com.company.enums.CourseStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;
    @Column
    private String name;
    @Column
    private Integer balance;
    @Column
    @Enumerated(EnumType.STRING)
    private CourseStatus status;
    @Column
    private LocalDateTime createData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filial_id",insertable = false,updatable = false)
    private BranchEntity filial;
    @Column(name = "filial_id")
    private String filial_id;
}