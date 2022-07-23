package com.company.service;

import com.company.dto.WorkerDTO;
import com.company.entity.WorkerEntity;
import com.company.enums.FilialStatus;
import com.company.enums.WorkerStatus;
import com.company.exp.ItemNotFoundExseption;
import com.company.exp.StatusNotActiveExseption;
import com.company.exp.WorkerAlreadyCreatedException;
import com.company.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository teacherRepository;

    //TODO create finish chack on
    public WorkerDTO create(WorkerDTO dto){
        Optional<WorkerEntity> optional1 = teacherRepository.findByEmail(dto.getEmail());
        if (optional1.isPresent()){
            throw new WorkerAlreadyCreatedException("Teacher already created pls replay");
        }

        Optional<WorkerEntity> optional = teacherRepository.findByPhone(dto.getPhone());
        if (optional.isPresent()){
            throw new WorkerAlreadyCreatedException("Teacher already created pls replay");
        }
        WorkerEntity entity = new WorkerEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setExpert(dto.getExpert());
        entity.setSale(dto.getSale());
        entity.setStatus(WorkerStatus.working);
        entity.setCreateDate(LocalDateTime.now());
        teacherRepository.save(entity);
        return toDTO(entity);
    }
    //TODO update finish chack on
    public WorkerDTO update(WorkerDTO dto, Integer phone){
        Optional<WorkerEntity> optional = teacherRepository.findByPhone(phone);
        if (optional.isEmpty()){
            throw new ItemNotFoundExseption("Teacher not found");
        }
        WorkerEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setPhone(phone);
        entity.setExpert(dto.getExpert());
        entity.setSale(dto.getSale());
        entity.setUpdateDate(LocalDateTime.now());
        teacherRepository.save(entity);
        return toDTO(entity);
    }
    //TODO getById finish chack on
    public WorkerDTO getById(Integer phone){
        Optional<WorkerEntity> optional = teacherRepository.findByPhone(phone);
        if (optional.isEmpty()){
            throw new ItemNotFoundExseption("Teacher not found");
        }
        if (optional.get().getStatus().equals(WorkerStatus.no_working)){
            throw new StatusNotActiveExseption("Status not active");
        }
        return toDTO(optional.get());
    }
    //TODO delete finish chack on
    public boolean delete(Integer phone){
        Optional<WorkerEntity> optional = teacherRepository.findByPhone(phone);
        if (optional.isEmpty()){
            throw new ItemNotFoundExseption("Teacher not found");
        }
        int n = teacherRepository.updateStatus(WorkerStatus.no_working,phone);
        return n > 0;
    }
    //TODO toDTO finish chack on
    public WorkerDTO toDTO(WorkerEntity entity){
        WorkerDTO dto = new WorkerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setExpert(entity.getExpert());
        dto.setSale(entity.getSale());
        dto.setStatus(entity.getStatus());
        dto.setCreateDate(entity.getCreateDate());
        dto.setUpdateDate(entity.getUpdateDate());
        return dto;
    }
}