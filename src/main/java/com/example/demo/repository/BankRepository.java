package com.example.demo.repository;

import com.example.demo.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findByBankName(String bankName);

    Optional<Bank> findById(Long id);

}
