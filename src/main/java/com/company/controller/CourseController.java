package com.company.controller;

import com.company.dto.filial.CourseDTO;
import com.company.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CourseDTO dto){
        return ResponseEntity.ok(courseService.create(dto));
    }

    @GetMapping("/getById/{name}")
    public ResponseEntity<?> getById(@PathVariable("name") String name){
        return ResponseEntity.ok(courseService.getById(name));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> delete(@PathVariable("name") String name){
        return ResponseEntity.ok(courseService.delete(name));
    }
}
