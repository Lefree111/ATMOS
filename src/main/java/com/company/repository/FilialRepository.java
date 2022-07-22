package com.company.repository;

import com.company.entity.FilialEntity;
import com.company.enums.FilialStatus;
import com.company.enums.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface FilialRepository extends JpaRepository<FilialEntity,String> {

    Optional<FilialEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query("update FilialEntity set status = :status where name = :name")
    int updateStatus(@Param("status") FilialStatus status, @Param("name") String name);

}
