package com.hdfc.accounts.repository;

import com.hdfc.accounts.domain.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, String> {
}
