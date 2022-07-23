package com.company.controller;

import com.company.dto.FilialDTO;
import com.company.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/filial")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody FilialDTO dto){
        return ResponseEntity.ok(filialService.create(dto));
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<?> update(@RequestBody FilialDTO dto, @PathVariable("name") String name){
        return ResponseEntity.ok(filialService.update(dto, name));
    }

    @GetMapping("/getById/{name}")
    public ResponseEntity<?> getById(@PathVariable("name") String name){
        return ResponseEntity.ok(filialService.getById(name));
    }

    @PutMapping("/updateStatusFilial/{name}")
    public ResponseEntity<?> updateStatusFilial(@PathVariable("name") String name){
        return ResponseEntity.ok(filialService.updateStatusFilial(name));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> delete(@PathVariable("name") String name){
        filialService.delete(name);
        return ResponseEntity.ok().build();
    }
}