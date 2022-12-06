package com.library.restapibookstore.controllers;

import com.library.restapibookstore.model.entities.BankCard;
import com.library.restapibookstore.model.entities.dtos.BankCardDto;
import com.library.restapibookstore.model.services.interfaces.BankCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bank-card")
//@CrossOrigin(origins = "localhost:8080", maxAge = 3600)
public class BankCardController {
    @Autowired
    private BankCardService bankCardService;

    @GetMapping
    public ResponseEntity<List<BankCard>> getAll() {
        List<BankCard> list = bankCardService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/balance")
    public ResponseEntity<BankCard> balance(@RequestBody BankCardDto obj) {
        var bc = new BankCard();
        BeanUtils.copyProperties(obj, bc);
        bc = bankCardService.getBalance(bc);
        return ResponseEntity.status(HttpStatus.OK).body(bc);
    }

    @PostMapping("/new")
    public ResponseEntity<BankCard> save(@RequestBody @Valid BankCardDto obj) {
        var card = new BankCard();
        BeanUtils.copyProperties(obj, card);
        return new ResponseEntity<>(bankCardService.save(card), HttpStatus.OK);
    }

    //solicitar cartão. (mandar - fazer cadastro de cliente para poder validar os dados antes.) (usar random para gerar número do cartão)

    //atualizar dados.


    //recarga/deposito

    //pagar (chamar método para pagar o empréstimo)
}
