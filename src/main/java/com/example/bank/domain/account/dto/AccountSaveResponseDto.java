package com.example.bank.domain.account.dto;

import com.example.bank.domain.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
