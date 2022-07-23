package com.company.repository;

import com.company.entity.SendMailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendMailRepository extends JpaRepository<SendMailEntity,String> {
}
