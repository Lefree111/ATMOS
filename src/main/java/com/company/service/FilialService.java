package com.company.service;

import com.company.dto.FilialDTO;
import com.company.entity.FilialEntity;
import com.company.enums.FilialStatus;
import com.company.exp.FilialAlreadyCreatedExseption;
import com.company.exp.FilialStatusChangeExseption;
import com.company.exp.ItemNotFoundExseption;
import com.company.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FilialService {

    @Autowired
    private FilialRepository filialRepository;

    //TODO finish chack on
    public FilialDTO create(FilialDTO dto) {
        Optional<FilialEntity> optional = filialRepository.findByName(dto.getName());
        if (optional.isPresent()) {
            throw new FilialAlreadyCreatedExseption("Filial already created pls replay");
        }
        FilialEntity entity = new FilialEntity();
        entity.setName(dto.getName());
        entity.setStudent_count(dto.getStudent_count());
        entity.setWorker_count(dto.getWorker_count());
        entity.setStatus(FilialStatus.open);
        entity.setCreateDate(LocalDateTime.now());
        filialRepository.save(entity);
        return toDTO(entity);
    }
    //TODO update chack on
    public FilialDTO update(FilialDTO dto,String name){
        Optional<FilialEntity> optional = filialRepository.findByName(name);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("Filial not found");
        }
        FilialEntity entity = optional.get();
        entity.setStudent_count(dto.getStudent_count());
        entity.setWorker_count(dto.getWorker_count());
        entity.setStatus(dto.getStatus());
        entity.setUpdateDate(LocalDateTime.now());
        filialRepository.save(entity);
        return toDTO(entity);
    }
    //TODO getById chack on
    public FilialDTO getById(String name){
        Optional<FilialEntity> optional = filialRepository.findByName(name);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("Filial not found");
        }
        return toDTO(optional.get());
    }
    //TODO updateStatusFilial chack on
    public Boolean updateStatusFilial(String name){
        Optional<FilialEntity> optional = filialRepository.findByName(name);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("Filial not found");
        }
        if (optional.get().equals(FilialStatus.close)){
            throw new FilialStatusChangeExseption("Filial's status no active");
        }
        int n = filialRepository.updateStatus(FilialStatus.close,name);
        return n > 0;
    }
    //TODO delete chack on
    public void delete(String name){
        Optional<FilialEntity> optional = filialRepository.findByName(name);
        if (optional.isEmpty()) {
            throw new ItemNotFoundExseption("Filial not found");
        }
        filialRepository.delete(optional.get());
    }
    //TODO toDTO chack on
    public FilialDTO toDTO(FilialEntity entity) {
        FilialDTO dto = new FilialDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStudent_count(entity.getStudent_count());
        dto.setWorker_count(entity.getWorker_count());
        dto.setStatus(entity.getStatus());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }
}