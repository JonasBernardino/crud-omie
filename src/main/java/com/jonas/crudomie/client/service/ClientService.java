package com.jonas.crudomie.client.service;

import com.jonas.crudomie.client.dto.ClientDtoFull;
import com.jonas.crudomie.client.dto.ClientDtoShort;
import com.jonas.crudomie.client.model.Client;
import com.jonas.crudomie.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<ClientDtoFull> findAllClientFull(Pageable pageable){
        Page<Client> result = clientRepository.findAll(pageable);
        Page<ClientDtoFull> page = result.map(x -> new ClientDtoFull(x));
        return page;
    }

    public Page<ClientDtoShort> findAllClientShort(Pageable pageable){
        Page<Client> result = clientRepository.findAll(pageable);
        Page<ClientDtoShort> page = result.map(x -> new ClientDtoShort(x));
        return page;
    }

    public ClientDtoFull findByIdClient(Long id){
        Client result = clientRepository.findById(id).get();
        ClientDtoFull dto = new ClientDtoFull(result);
        return dto;
    }
    public void deleteClient(Long id){
        findByIdClient(id);
        clientRepository.deleteById(id);
    }

    public Client create(ClientDtoShort obj) {
        return fromClient(obj);
    }

    private Client fromClient(ClientDtoShort obj){
        Client newObj = new Client();
        newObj.setId(obj.getId());
        newObj.setName(obj.getName());
        newObj.setNickname(obj.getNickname());
        newObj.setStatus(obj.getStatus());
        newObj.setSubscription(obj.getSubscription());
        return clientRepository.save(newObj);
    }


//    public Client findByIdClient(Long id){
//
//    }



}
