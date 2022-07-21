package com.company.controller;

import com.company.dto.TeacherDTO;
import com.company.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TeacherDTO dto) {
        return ResponseEntity.ok(teacherService.create(dto));
    }

    @PutMapping("/update/{phone}")
    public ResponseEntity<?> update(@RequestBody TeacherDTO dto, @PathVariable("phone") Integer phone) {
        return ResponseEntity.ok(teacherService.update(dto, phone));
    }

    @GetMapping("/getById/{phone}")
    public ResponseEntity<?> getById(@PathVariable("phone") Integer phone) {
        return ResponseEntity.ok(teacherService.getById(phone));
    }

    @DeleteMapping("/delete/{phone}")
    public ResponseEntity<?> delete(@PathVariable("phone") Integer phone) {
        return ResponseEntity.ok(teacherService.delete(phone));
    }
}
