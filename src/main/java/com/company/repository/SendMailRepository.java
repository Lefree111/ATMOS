package com.company.repository;

import com.company.entity.mail.SendMailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendMailRepository extends JpaRepository<SendMailEntity,String> {
}
