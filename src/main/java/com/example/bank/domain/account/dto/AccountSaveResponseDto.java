package com.example.bank.domain.account.dto;

import com.example.bank.domain.account.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountSaveResponseDto {
    private Long id;
    private Long number;
    private Long balance;

    public AccountSaveResponseDto(Account account){
        this.id = account.getId();
        this.number = account.getNumber();
        this.balance = account.getBalance();
    }

}
