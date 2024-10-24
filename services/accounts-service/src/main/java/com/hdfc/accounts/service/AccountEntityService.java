package com.hdfc.accounts.service;

import com.hdfc.accounts.domain.entity.AccountEntity;
import com.hdfc.accounts.domain.request.AccountEntityRequest;
import com.hdfc.accounts.domain.response.AccountEntityResponse;
import com.hdfc.accounts.repository.AccountEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountEntityService {
    @Autowired
    private AccountEntityRepository accountentityRepository;
    public AccountEntityResponse create(AccountEntityRequest request) {
        var saved = this.accountentityRepository.save(new AccountEntity(request.title(), request.isActive()));
        return new AccountEntityResponse(saved.getId(), saved.getTitle(), saved.isActive());
		
    }
}
