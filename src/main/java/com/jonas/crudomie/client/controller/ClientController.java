package com.jonas.crudomie.client.controller;

import com.jonas.crudomie.client.model.Client;
import com.jonas.crudomie.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAllClient(){
        List<Client> list = clientService.findAllClient();
        return ResponseEntity.ok().body(list);
    }
}
