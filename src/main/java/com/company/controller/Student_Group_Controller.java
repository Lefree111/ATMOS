package com.company.controller;

import com.company.dto.student.Student_Group_DTO;
import com.company.service.Student_Group_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/st_gr_con")
public class Student_Group_Controller {

    @Autowired
    private Student_Group_Service student_group_service;

    @PostMapping("/connect")
    public ResponseEntity<?> connect(@RequestBody Student_Group_DTO dto){
        return ResponseEntity.ok(student_group_service.connect(dto));
    }

    @DeleteMapping("/delete/{groupId}")
    public ResponseEntity<?> delete_group(@PathVariable("groupId") String groupId){
        student_group_service.delete_group(groupId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> delete_group_student(@PathVariable("studentId") String studentId){
        student_group_service.delete_group_student(studentId);
        return ResponseEntity.ok().build();
    }


}