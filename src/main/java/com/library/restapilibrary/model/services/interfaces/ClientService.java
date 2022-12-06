package com.library.restapibookstore.model.services.interfaces;

import com.library.restapibookstore.model.entities.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAll();

    public Client find(Long id);

    public Client save(Client client);

    public void delete(Long id);

    public Client update(Long id, Client client);
}
