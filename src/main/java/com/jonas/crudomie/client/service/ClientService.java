package com.jonas.crudomie.client.service;

import com.jonas.crudomie.client.dto.ClientDtoFull;
import com.jonas.crudomie.client.dto.ClientDtoShort;
import com.jonas.crudomie.client.model.Client;
import com.jonas.crudomie.client.repository.ClientRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
    public Client findById(Long id){
      Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:",id + Client.class.getName()));
    }

    public ClientDtoShort findByIdClientShort(Long id) {
        Client result = clientRepository.findById(id).get();
        ClientDtoShort dto = new ClientDtoShort(result);
        return dto;
    }

    public void deleteClient(Long id){
        findByIdClient(id);
        clientRepository.deleteById(id);
    }

    public Client createClient(ClientDtoShort obj) {
        return fromClient(obj);
    }
    public Client updateClientShort(ClientDtoShort obj) {
        findById(obj.getId());
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


}
