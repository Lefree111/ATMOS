package com.company.repository;

import com.company.entity.TeacherEntity;
import com.company.enums.StudentStatus;
import com.company.enums.TeacherStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity,String> {

    Optional<TeacherEntity> findByPhone(Integer phone);
    Optional<TeacherEntity> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update TeacherEntity set status = :status where phone = :phone")
    int updateStatus(@Param("status") TeacherStatus status, @Param("phone") Integer phone);

}
