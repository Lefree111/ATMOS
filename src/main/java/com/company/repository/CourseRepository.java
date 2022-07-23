package com.company.repository;

import com.company.entity.CourseEntity;
import com.company.enums.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {

    Optional<CourseEntity> findByName(String name);

    @Transactional
    @Modifying
    @Query("update  CourseEntity set status =:status where name =:name")
    int updateStatus(@Param("status") CourseStatus status, @Param("name") String name);
}
