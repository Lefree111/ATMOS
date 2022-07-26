package com.company.repository;

import com.company.entity.student.Student_Group_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Student_Group_Repository extends JpaRepository<Student_Group_Entity,String> {

    Optional<Student_Group_Entity> findByStudent_id(String studentId);

    Optional<Student_Group_Entity> findByGroup_id(String groupId);

    Optional<Student_Group_Entity> findByGroup_idAndStudent_id(String groupId,String studentId);


}
