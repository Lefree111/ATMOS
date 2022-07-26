package com.company.service;

import com.company.dto.CourseDTO;
import com.company.entity.CourseEntity;
import com.company.enums.CourseStatus;
import com.company.exp.CourseAlreadyCreatedExseption;
import com.company.exp.ItemNotFoundExseption;
import com.company.exp.StatusNotActiveExseption;
import com.company.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    
    public CourseDTO create(CourseDTO dto){
        Optional<CourseEntity> optional = courseRepository.findByName(dto.getName());
        if (optional.isPresent()){
            throw new CourseAlreadyCreatedExseption("Course Already Created pls replay");
        }
        CourseEntity entity = new CourseEntity();
        entity.setName(dto.getName());
        entity.setBalance(dto.getBalance());
        entity.setGroup_id(dto.getGroup_id());
        entity.setStatus(CourseStatus.open);
        entity.setCreateData(LocalDateTime.now());
        courseRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public CourseEntity getById(String name){
        Optional<CourseEntity> optional = courseRepository.findByName(name);
        if (optional.isEmpty()){
            throw new ItemNotFoundExseption("Course Already Created pls replay");
        }
        if (optional.get().getStatus().equals(CourseStatus.close)){
            throw new StatusNotActiveExseption("Status not active");
        }
        return optional.get();
    }

    public Boolean delete(String name){
        Optional<CourseEntity> optional = courseRepository.findByName(name);
        if (optional.isEmpty()){
            throw new ItemNotFoundExseption("Course Already Created pls replay");
        }
        if (optional.get().getStatus().equals(CourseStatus.close)){
            throw new StatusNotActiveExseption("Status not active");
        }
        int n = courseRepository.updateStatus(CourseStatus.close,name);
        return n > 0;
    }
}