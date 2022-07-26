package com.company.entity.mail;

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
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String fromAccount;
    @Column(nullable = false)
    private String toAccount;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDateTime sendMailDate;
}
