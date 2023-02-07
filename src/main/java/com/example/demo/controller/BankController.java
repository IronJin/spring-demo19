package com.example.demo.controller;

import com.example.demo.domain.Bank;
import com.example.demo.domain.BankDTO;
import com.example.demo.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BankController {

    private final BankService service;

    @GetMapping("/api/banks/{id}")
    public Bank findBank(@PathVariable Long id) {
        return service.findBank(id);
    }

    @GetMapping("/api/banks/name")
    public Optional<Bank> findBankByName(@RequestParam String bankName) {
        return service.findBankByName(bankName);
    }

    @PostMapping("/api/bankInsert")
    public Bank saveBank(@RequestBody BankDTO bankDTO) {
        Bank bank = service.saveBank(bankDTO);
        return bank;
    }

    @PutMapping("/api/bankUpdate/{id}")
    public Bank updateBank(@PathVariable Long id, @RequestBody BankDTO bankDTO) {

        return service.updateBank(id, bankDTO);

    }

    @DeleteMapping("/api/bank/{id}")
    public void deleteBank(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
    }


}
