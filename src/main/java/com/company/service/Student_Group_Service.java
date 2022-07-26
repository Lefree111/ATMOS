package com.company.service;

import com.company.dto.student.Student_Group_DTO;
import com.company.entity.student.Student_Group_Entity;
import com.company.exp.ItemNotFoundExseption;
import com.company.exp.StatusNotActiveExseption;
import com.company.repository.Student_Group_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Student_Group_Service {
    @Autowired
    private Student_Group_Repository student_group_repository;

    public Student_Group_DTO connect(Student_Group_DTO dto) {
        Optional<Student_Group_Entity> optional = student_group_repository.findByStudent_id(dto.getStudent_id());
        if (optional.isPresent()) {
            throw new StatusNotActiveExseption("Status not active");
        }
        Student_Group_Entity entity = new Student_Group_Entity();
        entity.setStudent_id(dto.getStudent_id());
        entity.setGroup_id(dto.getGroup_id());
        student_group_repository.save(entity);
        return dto;
    }

    public void delete_group( String groupId) {
        Optional<Student_Group_Entity> optional1 = student_group_repository.findByGroup_id(groupId);
        if (optional1.isEmpty()) {
            throw new ItemNotFoundExseption("Status not active");
        }
        student_group_repository.delete(optional1.get());
    }


    public void delete_group_student(String studentId) {
        Optional<Student_Group_Entity> optional1 = student_group_repository.findByGroup_id(studentId);
        if (optional1.isEmpty()) {
            throw new ItemNotFoundExseption("Status not active");
        }
        student_group_repository.delete(optional1.get());
    }
}