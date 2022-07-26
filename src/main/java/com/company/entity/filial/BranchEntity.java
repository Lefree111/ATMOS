package com.company.entity.filial;

import com.company.enums.FilialStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "filial")
public class BranchEntity {
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
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;
}