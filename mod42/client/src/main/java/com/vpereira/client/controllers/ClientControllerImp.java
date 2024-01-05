package com.vpereira.client.controllers;

import com.vpereira.client.core.domain.Client;
import com.vpereira.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientControllerImp implements ClientController{

    @Autowired
    ClientService clientService;

    @PostMapping
    @Override
    public ResponseEntity<Client> create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable(name = "id") UUID id) {
        return clientService.update(client, id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable(name = "id") UUID id) {
        clientService.delete(id);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Optional<Client>> findById(@PathVariable(name = "id")UUID id) {
        return clientService.findById(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Client>> findAll() {
        return clientService.findAll();
    }
}
