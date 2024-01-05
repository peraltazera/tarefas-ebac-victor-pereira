package com.vpereira.client.services;

import com.vpereira.client.core.domain.Client;
import com.vpereira.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ResponseEntity<Client> create(Client client) {
        clientRepository.save(client);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @Override
    public ResponseEntity<Client> update(Client client, UUID id) {
        Optional<Client> clientEntity = clientRepository.findById(id);
        if(clientEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        client.setId(id);
        clientRepository.save(client);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @Override
    public void delete(UUID id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Optional<Client>> findById(UUID id) {
        Optional<Client> client = clientRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @Override
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }
}
