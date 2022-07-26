package com.company.controller;

import com.company.dto.filial.BranchDTO;
import com.company.service.Branchervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/filial")
public class BranchController {

    @Autowired
    private Branchervice filialService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BranchDTO dto){
        return ResponseEntity.ok(filialService.create(dto));
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<?> update(@RequestBody BranchDTO dto, @PathVariable("name") String name){
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