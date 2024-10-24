package com.mybank.daprtestservice.controller;

import com.mybank.daprtestservice.domain.request.LoginEntityRequest;
import com.mybank.daprtestservice.domain.request.MyEntityRequest;
import com.mybank.daprtestservice.domain.response.MyEntityResponse;
import com.mybank.daprtestservice.service.DaprService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/dapr")
@Slf4j
public class DaprController {

    @Autowired
    private DaprService daprService;


    @PostMapping(path = "/publish")
    public ResponseEntity<MyEntityResponse> create(@Valid @RequestBody MyEntityRequest myentityRequest) {
        MyEntityResponse response = this.daprService.create(myentityRequest);
        return ResponseEntity.accepted().body(response);
    }
    @PostMapping(path = "/serviceCall")
    public ResponseEntity<String> serviceCall(
            @Valid @RequestBody LoginEntityRequest loginEntityRequest) {
     String res   =  this.daprService.serviceToService(loginEntityRequest);
     return ResponseEntity.accepted().body(res);
    }
    @PostMapping(path = "/saveStore")
    public ResponseEntity<String> saveStore(
            @Valid @RequestBody LoginEntityRequest loginEntityRequest) {
        String res   =  this.daprService.saveStore();
        return ResponseEntity.accepted().body(res);
    }

    @PostMapping(path = "/getStore")
    public ResponseEntity<String> getStore(
            @Valid @RequestBody LoginEntityRequest loginEntityRequest) {
        String res   =  this.daprService.getStore();
        return ResponseEntity.accepted().body(res);
    }
}
