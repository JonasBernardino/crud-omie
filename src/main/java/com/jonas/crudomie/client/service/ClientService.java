package com.jonas.crudomie.client.service;

import com.jonas.crudomie.client.model.Client;
import com.jonas.crudomie.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<Client> findAllClient(Pageable pageable){
        Page<Client> result = clientRepository.findAll(pageable);
        return result;
    }

//    public Client findByIdClient(Long id){
//
//    }



}
