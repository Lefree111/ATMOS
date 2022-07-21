package com.company.service;

import com.company.dto.TeacherDTO;
import com.company.entity.TeacherEntity;
import com.company.enums.TeacherStatus;
import com.company.exp.ItemNotFoundExseption;
import com.company.exp.TeacherAlreadyCreatedException;
import com.company.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    //TODO create finish chack not
    public TeacherDTO create(TeacherDTO dto){
        Optional<TeacherEntity> optional1 = teacherRepository.findByEmail(dto.getEmail());
        if (optional1.isPresent()){
            throw new TeacherAlreadyCreatedException("Teacher already created pls replay");
        }

        Optional<TeacherEntity> optional = teacherRepository.findByPhone(dto.getPhone());
        if (optional.isPresent()){
            throw new TeacherAlreadyCreatedException("Teacher already created pls replay");
        }
        TeacherEntity entity = new TeacherEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setExpert(dto.getExpert());
        entity.setSale(dto.getSale());
        entity.setStatus(TeacherStatus.working);
        entity.setCreateDate(LocalDateTime.now());
        teacherRepository.save(entity);
        return toDTO(entity);
    }
    //TODO update finish chack not
    public TeacherDTO update(TeacherDTO dto,Integer phone){
        Optional<TeacherEntity> optional = teacherRepository.findByPhone(phone);
        if (optional.isEmpty()){
            throw new ItemNotFoundExseption("Teacher not found");
        }
        TeacherEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setExpert(dto.getExpert());
        entity.setSale(dto.getSale());
        entity.setUpdateDate(LocalDateTime.now());
        teacherRepository.save(entity);
        return toDTO(entity);
    }
    //TODO getById finish chack not
    public TeacherDTO getById(Integer phone){
        Optional<TeacherEntity> optional = teacherRepository.findByPhone(phone);
        if (optional.isEmpty()){
            throw new ItemNotFoundExseption("Teacher not found");
        }
        return toDTO(optional.get());
    }
    //TODO delete finish chack not
    public boolean delete(Integer phone){
        Optional<TeacherEntity> optional = teacherRepository.findByPhone(phone);
        if (optional.isEmpty()){
            throw new ItemNotFoundExseption("Teacher not found");
        }
        int n = teacherRepository.updateStatus(TeacherStatus.no_working,phone);
        return n > 0;
    }
    //TODO toDTO finish chack on
    public TeacherDTO toDTO(TeacherEntity entity){
        TeacherDTO dto = new TeacherDTO();
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