package com.mybank.daprtestservice.repository;

import com.mybank.daprtestservice.domain.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, String> {
}
