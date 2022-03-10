package com.jonas.crudomie.client.controller;

import com.jonas.crudomie.client.dto.ClientDtoFull;
import com.jonas.crudomie.client.dto.ClientDtoShort;
import com.jonas.crudomie.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/full")
    public Page<ClientDtoFull> findAllClientFull(Pageable pageable){
        return clientService.findAllClientFull(pageable);
    }
    @GetMapping("/short")
    public Page<ClientDtoShort> findAllClientShort(Pageable pageable){
        return clientService.findAllClientShort(pageable);
    }


}
