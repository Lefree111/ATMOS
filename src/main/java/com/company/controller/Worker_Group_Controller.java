package com.company.controller;

import com.company.dto.student.Student_Group_DTO;
import com.company.dto.worker.Worker_Group_DTO;
import com.company.service.Worker_Group_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wor_gr_con")
public class Worker_Group_Controller {

    @Autowired
    private Worker_Group_Service worker_group_service;

    @PostMapping("/connect")
    public ResponseEntity<?> connect(@RequestBody Worker_Group_DTO dto){
        return ResponseEntity.ok(worker_group_service.connect(dto));
    }

    @DeleteMapping("/delete/{groupId}")
    public ResponseEntity<?> delete_group(@PathVariable("groupId") String groupId){
        worker_group_service.delete_group(groupId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{workerId}")
    public ResponseEntity<?> delete_group_worker(@PathVariable("workerId") String workerId){
        worker_group_service.delete_group_worker(workerId);
        return ResponseEntity.ok().build();
    }


}