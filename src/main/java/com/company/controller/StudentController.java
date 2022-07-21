package com.company.controller;

import com.company.dto.StudentDTO;
import com.company.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.create(dto));
    }

    @GetMapping("/getById/{phone}")
    public ResponseEntity<?> getById(@PathVariable("phone") Integer phone) {
        return ResponseEntity.ok(studentService.getById(phone));
    }

    @PutMapping("/update/{phone}")
    public ResponseEntity<?> update(@RequestBody StudentDTO dto, @PathVariable("phone") Integer phone) {
        return ResponseEntity.ok(studentService.update(dto, phone));
    }

    @DeleteMapping("/delete/{phone}")
    public ResponseEntity<?> delete(@PathVariable("phone") Integer phone) {
        studentService.delete(phone);
        return ResponseEntity.ok().build();
    }

    @PutMapping("updateStudentStatus/{phone}")
    public ResponseEntity<?> updateStudentStatus(@PathVariable("phone") Integer phone) {
        return ResponseEntity.ok(studentService.updateStudentStatus(phone));
    }

    @PostMapping("/message/{to}")
    public ResponseEntity<?> message(@PathVariable("to") String to) {
        studentService.sendMessage(to);
        return ResponseEntity.ok().build();
    }

}
