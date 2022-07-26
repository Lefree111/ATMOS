package com.company.service;

import com.company.dto.filial.GroupDTO;
import com.company.entity.filial.GroupEntity;
import com.company.enums.GroupStatus;
import com.company.exp.GroupAlreadyCreatedExseption;
import com.company.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public GroupDTO create(GroupDTO dto){
        Optional<GroupEntity> optional = groupRepository.findByName(dto.getName());
        if (optional.isPresent()){
            throw new GroupAlreadyCreatedExseption("group alread created pls replay");
        }
        GroupEntity entity = new GroupEntity();
        entity.setName(dto.getName());
        entity.setCourse_id(dto.getCourseId());
        entity.setStatus(GroupStatus.open);
        entity.setCreateDate(LocalDateTime.now());
        groupRepository.save(entity);
        return dto;
    }

}