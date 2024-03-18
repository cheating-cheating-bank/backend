package com.example.bank.domain.account.dto;


import com.example.bank.domain.account.entity.Account;
import com.example.bank.domain.user.entity.User;
import lombok.*;

//number, password
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountSaveRequestDto {
    Long number;
    Long password;

    public Account toEntity(User user){
        return Account.builder()
                .number(number)
                .password(password)
                .build();
    }
}
