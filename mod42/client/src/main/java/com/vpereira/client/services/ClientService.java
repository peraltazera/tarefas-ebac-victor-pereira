package com.vpereira.client.services;

import com.vpereira.client.core.domain.Client;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {
    public ResponseEntity<Client> create(Client client);
    public  ResponseEntity<Client> update(Client client, UUID id);
    public void delete(UUID id);
    public ResponseEntity<Optional<Client>> findById(UUID id);
    public ResponseEntity<List<Client>> findAll();
}
