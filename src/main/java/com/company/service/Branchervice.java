package com.company.service;

import com.company.repository.BranchRepository;
import com.company.dto.filial.BranchDTO;
import com.company.entity.filial.BranchEntity;
import com.company.enums.FilialStatus;
import com.company.exp.FilialAlreadyCreatedExseption;
import com.company.exp.FilialStatusChangeExseption;
import com.company.exp.ItemNotFoundExseption;
import com.company.exp.StatusNotActiveExseption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Branchervice {

    @Autowired
    private BranchRepository branchRepository;

    //TODO finish chack on
    public BranchDTO create(BranchDTO dto) {
        Optional<BranchEntity> optional = branchRepository.findByName(dto.getName());
        if (optional.isPresent()) {
            throw new FilialAlreadyCreatedExseption("Filial already created pls replay");
        }
        BranchEntity entity = new BranchEntity();
        entity.setName(dto.getName());
        entity.setStatus(FilialStatus.open);
        entity.setCreateDate(LocalDateTime.now());
        branchRepository.save(entity);
        return toDTO(entity);
    }

    //TODO update chack on
    public BranchDTO update(BranchDTO dto, String name) {
        Optional<BranchEntity> optional = branchRepository.findByName(name);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("Filial not found");
        }
        BranchEntity entity = optional.get();
        entity.setStatus(dto.getStatus());
        entity.setUpdateDate(LocalDateTime.now());
        branchRepository.save(entity);
        return toDTO(entity);
    }

    //TODO getById chack on
    public BranchDTO getById(String name) {
        Optional<BranchEntity> optional = branchRepository.findByName(name);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("Filial not found");
        }
        if (optional.get().getStatus().equals(FilialStatus.close)) {
            throw new StatusNotActiveExseption("Status not active");
        }
        return toDTO(optional.get());
    }

    //TODO updateStatusFilial chack on
    public Boolean updateStatusFilial(String name) {
        Optional<BranchEntity> optional = branchRepository.findByName(name);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("Filial not found");
        }
        if (optional.get().equals(FilialStatus.close)) {
            throw new FilialStatusChangeExseption("Filial's status no active");
        }
        int n = branchRepository.updateStatus(FilialStatus.close, name);
        return n > 0;
    }

    //TODO delete chack on
    public void delete(String name) {
        Optional<BranchEntity> optional = branchRepository.findByName(name);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("Filial not found");
        }
        branchRepository.delete(optional.get());
    }

    //TODO toDTO chack on
    public BranchDTO toDTO(BranchEntity entity) {
        BranchDTO dto = new BranchDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }
}