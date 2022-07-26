package com.company.repository;

import com.company.entity.worker.WorkerEntity;
import com.company.enums.WorkerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface WorkerRepository extends JpaRepository<WorkerEntity,String> {

    Optional<WorkerEntity> findByPhone(Integer phone);

    Optional<WorkerEntity> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update WorkerEntity set status = :status where phone = :phone")
    int updateStatus(@Param("status") WorkerStatus status, @Param("phone") Integer phone);

}
