package com.company.entity.worker;

import com.company.entity.filial.GroupEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table
public class Worker_Group_Entity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id", insertable = false, updatable = false)
    private WorkerEntity worker;
    @Column(name = "worker_id")
    private String worker_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private GroupEntity group;
    @Column(name = "group_id")
    private String group_id;
}