package com.hdfc.login.service;

import com.hdfc.login.domain.entity.LoginEntity;
import com.hdfc.login.domain.request.LoginEntityRequest;
import com.hdfc.login.domain.response.LoginEntityResponse;
import com.hdfc.login.repository.LoginEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class LoginEntityService {
    @Autowired
    private LoginEntityRepository loginentityRepository;
    public LoginEntityResponse create(LoginEntityRequest request) {
        log.info("request {}", request);
        LoginEntity saved = this.loginentityRepository.save(new LoginEntity(request.getTitle(), request.isActive()));
        return new LoginEntityResponse(saved.getId(), saved.getTitle(), saved.isActive());
    }
}
