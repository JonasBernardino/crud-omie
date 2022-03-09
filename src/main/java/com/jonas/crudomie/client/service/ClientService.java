package com.jonas.crudomie.client.service;

import com.jonas.crudomie.client.model.Client;
import com.jonas.crudomie.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAllClient(){
        return clientRepository.findAll();
    }


}
