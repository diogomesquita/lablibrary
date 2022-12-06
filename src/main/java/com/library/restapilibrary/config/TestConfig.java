package com.library.restapilibrary.config;

import com.library.restapilibrary.model.entities.*;
import com.library.restapilibrary.model.entities.enums.CardType;
import com.library.restapilibrary.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private BankCardRepository bankCardRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void run(String... args) throws Exception {

        BankCard bc0 = new BankCard("c4l0t3ir0", 0.00, 00.00, CardType.CREDIT);
        BankCard bc1 = new BankCard("s1234p5", 100.00, 1300.00, CardType.CREDIT);
        BankCard bc2 = new BankCard("p1234s5", 101.00, 2300.00, CardType.DEBIT);
        BankCard bc3 = new BankCard("f1234d5", 200.00, 300.00, CardType.CREDIT);
        BankCard bc4 = new BankCard("d1234f5", 201.00, 4300.00, CardType.DEBIT);
        BankCard bc5 = new BankCard("d1234f5", 201.00, 4300.00, CardType.DEBIT);
        BankCard bc6 = new BankCard("d1nh31r0", 2000.0, 20000.00, CardType.DEBIT);

        var cli0 = new Client("Caloteiro", "00000000000", bc0);
        var cli1 = new Client("Maria", "11111111111", bc1);
        var cli2 = new Client("josé", "22222222222", bc2);
        var cli3 = new Client("joao", "33333333333", bc3);
        var cli4 = new Client("rita", "44444444444", bc4);
        var cli5 = new Client("Ricão", "55555555555", bc6);

        bankCardRepository.saveAll(Arrays.asList(bc1, bc2, bc3, bc4, bc5, bc0, bc6));
        clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli0, cli5));

        Author a0 = new Author("caristino");
        Author a1 = new Author("jacobino");
        Author a2 = new Author("serafino");
        Author a3 = new Author("crotilde");
        Author a4 = new Author("florentina");
        Author a5 = new Author("florentina");

        Book b0 = new Book("Livro CARÍSSIMO", 1, 10000.01, a0);
        Book b1 = new Book("O senhor dos aneis", 2, 12.12, a1);
        Book b2 = new Book("O poderoso chefão", 22, 22.22, a2);
        Book b3 = new Book("E o vento levou", 1, 13.12, a3);
        Book b4 = new Book("madame Bovary", 3, 33.44,a4);
        Book b5 = new Book("Mercador de veneza", 4, 11.11, a5);

        authorRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a0));
        bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b0));

        Loan l1 = new Loan(LocalDate.now(), LocalDate.now().plusDays(1), b1.getPrice(),true, b1, cli2);
        Loan l2 = new Loan(LocalDate.now(), LocalDate.now().plusDays(2), b3.getPrice(),false, b3, cli3);
        Loan l3 = new Loan(LocalDate.now(), LocalDate.now().plusDays(3), b4.getPrice(),true, b4, cli1);
        Loan l4 = new Loan(LocalDate.now(), LocalDate.now().plusDays(4), b5.getPrice(), false, b2, cli4);

        loanRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
    }
}