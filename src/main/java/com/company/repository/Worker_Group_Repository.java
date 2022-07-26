package com.company.repository;

import com.company.entity.student.Student_Group_Entity;
import com.company.entity.worker.Worker_Group_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Worker_Group_Repository extends JpaRepository<Worker_Group_Entity,String> {

    Optional<Worker_Group_Entity> findByWorker_id(String workerId);

    Optional<Worker_Group_Entity> findByGroup_id(String groupId);
}
