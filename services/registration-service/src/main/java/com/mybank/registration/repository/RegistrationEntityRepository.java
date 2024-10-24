package com.mybank.registration.repository;

import com.mybank.registration.domain.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationEntityRepository extends JpaRepository<RegistrationEntity, String> {
}
