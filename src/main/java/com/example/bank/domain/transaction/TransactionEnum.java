package com.example.bank.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TransactionEnum {

    WITHDRAW("출금"), DEPOSIT("입금"), TRANCFER("이체"), ALL("입출금내역");

    private final String value;

}
