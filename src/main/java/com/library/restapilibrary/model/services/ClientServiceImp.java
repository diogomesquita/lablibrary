package com.library.restapilibrary.model.services;

import com.library.restapilibrary.exceptions.NotFoundExceptions;
import com.library.restapilibrary.model.entities.Client;
import com.library.restapilibrary.model.repositories.ClientRepository;
import com.library.restapilibrary.model.services.interfaces.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        List<Client> list = clientRepository.findAll();
        return list;
    }

    @Override
    public Client find(Long id) {
        Optional<Client> dbClient = clientRepository.findById(id);
        return dbClient.orElseThrow(() -> {
            return new NotFoundExceptions(id);
        });
    }

    @Override
    public Client save(Client client) {
        if(clientRepository.existsByName(client.getName())) {
            throw new DataIntegrityViolationException(String.format("já tem %s", client.getName()));
        }
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Long id, Client client) {
        Client dbClient = find(id);
        BeanUtils.copyProperties(client, dbClient);
        return dbClient;
    }
}