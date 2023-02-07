package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
public class Bank {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;

    private String bankType;

    private String description;

    private int regUser;

    private Timestamp modDate;


    //내부 업데이트 비지니스 로직
    public static Bank createBank(BankDTO bankDTO) {

        Bank bank = new Bank();
        bank.setBankName(bankDTO.getBankName());
        bank.setBankType(bankDTO.getBankType());
        bank.setDescription(bankDTO.getDescription());

        return bank;
    }

    //내부 업데이트 비지니스 로직
    public void updateBank(BankDTO bankDTO) {
        this.bankName = bankDTO.getBankName();
        this.bankType = bankDTO.getBankType();
        this.description = bankDTO.getDescription();
    }


}
