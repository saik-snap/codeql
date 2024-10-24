package com.hdfc.login.controller;

import com.hdfc.login.domain.request.LoginEntityRequest;
import com.hdfc.login.domain.response.LoginEntityResponse;
import com.hdfc.login.service.LoginEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/loginentity")
public class LoginEntityController {

    @Autowired
    private LoginEntityService loginentityService;

    @PostMapping
    public ResponseEntity<LoginEntityResponse> create(@Valid @RequestBody LoginEntityRequest loginentityRequest) {
        LoginEntityResponse response = this.loginentityService.create(loginentityRequest);
        return ResponseEntity.accepted().body(response);
    }

}
