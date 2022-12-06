package com.library.restapilibrary.controllers;

import com.library.restapilibrary.model.entities.Client;
import com.library.restapilibrary.model.entities.dtos.ClientDto;
import com.library.restapilibrary.model.services.interfaces.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>((List<Client>) clientService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody @Valid ClientDto clientDto) {
        Client client =  new Client();
        BeanUtils.copyProperties(clientDto, client);
        return new ResponseEntity<>((Client) clientService.save(client), HttpStatus.OK);
    }
}