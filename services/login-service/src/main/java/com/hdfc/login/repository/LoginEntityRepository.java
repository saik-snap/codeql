package com.hdfc.login.repository;

import com.hdfc.login.domain.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginEntityRepository extends JpaRepository<LoginEntity, String> {
}
