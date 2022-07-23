package com.company.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "mail_history")
public class SendMailEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String username;
    @Column
    private LocalDateTime sendMailDate;
}
