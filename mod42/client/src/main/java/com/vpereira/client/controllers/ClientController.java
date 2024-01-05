package com.vpereira.client.controllers;

import com.vpereira.client.core.domain.Client;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientController {
    public ResponseEntity<Client> create(Client client);
    public  ResponseEntity<Client> update(Client client, UUID id);
    public void delete(UUID id);
    public ResponseEntity<Optional<Client>> findById(UUID id);
    public ResponseEntity<List<Client>> findAll();
}
