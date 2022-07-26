package com.company.repository;

import com.company.entity.filial.BranchEntity;
import com.company.enums.FilialStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface BranchRepository extends JpaRepository<BranchEntity,String> {

    Optional<BranchEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query("update BranchEntity set status = :status where name = :name")
    int updateStatus(@Param("status") FilialStatus status, @Param("name") String name);

}
