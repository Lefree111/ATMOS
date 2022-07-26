package com.company.repository;

import com.company.entity.filial.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<GroupEntity,String> {

    Optional<GroupEntity> findByName(String name);

}
