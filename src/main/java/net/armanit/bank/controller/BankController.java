package net.armanit.bank.controller;

import lombok.extern.slf4j.Slf4j;
import net.armanit.bank.model.Bank;
import net.armanit.bank.model.Response;
import net.armanit.bank.repository.AddressRepository;
import net.armanit.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/bank")
public class BankController {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    AddressRepository addressRepository;

    @PostMapping("/create")
    public ResponseEntity<Response> createBank(RequestEntity<Bank> requestEntity) {

//        log.info("address");
//        System.out.println(payload.getBody().getBankCode());
//        System.out.println(payload.getBody().getBankName());
//        System.out.println(payload.getBody().getBankAddress().getAddress1());
        Bank bank = requestEntity.getBody();
//        bank.setBankName( (String) payload.get("bankCode"));
//        Bank bank = requestEntity.getBody();
//        log.info(bank.getBankCode());
//        String address = bank.getBankAddress().getAddress1();
//        log.info(address);




        bankRepository.save(bank);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response("200", "Bank created successfully"));
    }
}
