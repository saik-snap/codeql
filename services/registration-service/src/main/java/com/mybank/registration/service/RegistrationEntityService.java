package com.mybank.registration.service;

import com.mybank.registration.domain.entity.RegistrationEntity;
import com.mybank.registration.domain.request.RegistrationEntityRequest;
import com.mybank.registration.domain.response.RegistrationEntityResponse;
import com.mybank.registration.repository.RegistrationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationEntityService {
    @Autowired
    private RegistrationEntityRepository registrationentityRepository;
    public RegistrationEntityResponse create(RegistrationEntityRequest request) {
        var saved = this.registrationentityRepository.save(new RegistrationEntity(request.title(), request.isActive()));
        return new RegistrationEntityResponse(saved.getId(), saved.getTitle(), saved.isActive());
		
    }
}
