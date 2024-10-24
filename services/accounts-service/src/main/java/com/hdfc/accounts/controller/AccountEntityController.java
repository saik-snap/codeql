package com.hdfc.accounts.controller;

import com.hdfc.accounts.domain.request.AccountEntityRequest;
import com.hdfc.accounts.domain.response.AccountEntityResponse;
import com.hdfc.accounts.service.AccountEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/accountentity")
public class AccountEntityController {

    @Autowired
    private AccountEntityService accountentityService;

    @PostMapping
    public ResponseEntity<AccountEntityResponse> create(@Valid @RequestBody AccountEntityRequest accountentityRequest) {
        AccountEntityResponse response = this.accountentityService.create(accountentityRequest);
        return ResponseEntity.accepted().body(response);
    }

}
