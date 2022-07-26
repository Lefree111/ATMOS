package com.company.service;

import com.company.dto.student.Student_Group_DTO;
import com.company.dto.worker.Worker_Group_DTO;
import com.company.entity.student.Student_Group_Entity;
import com.company.entity.worker.Worker_Group_Entity;
import com.company.exp.ItemNotFoundExseption;
import com.company.exp.StatusNotActiveExseption;
import com.company.repository.Worker_Group_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Worker_Group_Service {

    @Autowired
    private Worker_Group_Repository worker_group_repository;

    public Worker_Group_DTO connect(Worker_Group_DTO dto) {
        Optional<Worker_Group_Entity> optional = worker_group_repository.findByWorker_id(dto.getWorker_id());
        if (optional.isPresent()) {
            throw new StatusNotActiveExseption("Status not active");
        }
        Worker_Group_Entity entity = new Worker_Group_Entity();
        entity.setGroup_id(dto.getGroup_id());
        entity.setWorker_id(dto.getWorker_id());
        worker_group_repository.save(entity);
        return dto;
    }

    public void delete_group(String groupId) {
        Optional<Worker_Group_Entity> optional1 = worker_group_repository.findByGroup_id(groupId);
        if (optional1.isEmpty()) {
            throw new ItemNotFoundExseption("Status not active");
        }
        worker_group_repository.delete(optional1.get());
    }

    public void delete_group_worker(String worker) {
        Optional<Worker_Group_Entity> optional1 = worker_group_repository.findByWorker_id(worker);
        if (optional1.isEmpty()) {
            throw new ItemNotFoundExseption("Status not active");
        }
        worker_group_repository.delete(optional1.get());
    }



}