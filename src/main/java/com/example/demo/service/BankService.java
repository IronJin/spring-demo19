package com.example.demo.service;

import com.example.demo.domain.Bank;
import com.example.demo.domain.BankDTO;
import com.example.demo.repository.BankRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public Bank findBank(Long id) {
        return bankRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    public Optional<Bank> findBankByName(String bankName) {
        return Optional.ofNullable(bankRepository.findByBankName(bankName));
    }

    public Bank saveBank(BankDTO bankDTO) {
        Bank bank = Bank.createBank(bankDTO);
        return bankRepository.save(bank);
    }

    public Bank updateBank(Long id, BankDTO bankDTO) {

        Optional<Bank> bank = bankRepository.findById(id);
        bank.get().updateBank(bankDTO);
        return bankRepository.save(bank.get());

    }

    public void deleteById(Long id) {
        bankRepository.deleteById(id);
    }

}
