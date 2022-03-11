package com.jonas.crudomie.client.controller;

import com.jonas.crudomie.client.dto.ClientDtoFull;
import com.jonas.crudomie.client.dto.ClientDtoShort;
import com.jonas.crudomie.client.model.Client;
import com.jonas.crudomie.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping("/{id}")
    public ResponseEntity<ClientDtoFull> findByIdClient(@PathVariable Long id){
        ClientDtoFull clientDtoFull = clientService.findByIdClient(id);
        return ResponseEntity.ok().body(clientDtoFull);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deleteCliEntity(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ClientDtoShort> create(@RequestBody ClientDtoShort obj){
        obj = new ClientDtoShort(clientService.create(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }



}
