package com.company.repository;

import com.company.entity.student.StudentEntity;
import com.company.enums.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {

    Optional<StudentEntity> findByEmail(String email);

    Optional<StudentEntity> findByPhone(Integer phone);

    @Transactional
    @Modifying
    @Query("update StudentEntity set status = :status where phone = :phone")
    int updateStatus(@Param("status") StudentStatus status, @Param("phone") Integer phone);

}
