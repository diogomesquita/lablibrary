package com.library.restapilibrary.controllers;

import com.library.restapilibrary.model.entities.Book;
import com.library.restapilibrary.model.entities.Client;
import com.library.restapilibrary.model.entities.Loan;
import com.library.restapilibrary.model.entities.dtos.BookDto;
import com.library.restapilibrary.model.entities.dtos.ClientDto;
import com.library.restapilibrary.model.entities.dtos.LoanDto;
import com.library.restapilibrary.model.services.interfaces.LoanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Loan>> getAll() {
        return new ResponseEntity<>((List<Loan>) loanService.getAll(), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Loan> save(@RequestBody @Valid ClientDto clientDto, @RequestBody @Valid BookDto bookDto) {
        var b = new Book();
        var c = new Client();
        BeanUtils.copyProperties(clientDto, c);
        BeanUtils.copyProperties(bookDto, b);
        var loan = new Loan();
        loan =  loanService.save(c, b);
        return ResponseEntity.status(HttpStatus.OK).body(loan);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Loan> devolution(@PathVariable Long id, @RequestBody @Valid LoanDto loanDto) {
        var loan = new Loan();
        BeanUtils.copyProperties(loanDto, loan);
        loan = loanService.update(id, loan);
        return new ResponseEntity<>(loan, HttpStatus.OK );
    }
}