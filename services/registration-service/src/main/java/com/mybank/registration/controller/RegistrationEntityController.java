package com.mybank.registration.controller;

import com.mybank.registration.domain.request.RegistrationEntityRequest;
import com.mybank.registration.domain.response.RegistrationEntityResponse;
import com.mybank.registration.service.RegistrationEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/registrationentity")
public class RegistrationEntityController {

    @Autowired
    private RegistrationEntityService registrationentityService;

    @PostMapping
    public ResponseEntity<RegistrationEntityResponse> create(@Valid @RequestBody RegistrationEntityRequest registrationentityRequest) {
        RegistrationEntityResponse response = this.registrationentityService.create(registrationentityRequest);
        return ResponseEntity.accepted().body(response);
    }

}
