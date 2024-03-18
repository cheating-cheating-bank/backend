package com.example.bank.domain.account.sevice;

import com.example.bank.domain.account.dto.AccountSaveRequestDto;
import com.example.bank.domain.account.dto.AccountSaveResponseDto;
import com.example.bank.domain.account.entity.Account;
import com.example.bank.domain.account.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AccountService {
    private final AccountRepository accountRepository;


    @Transactional
    public AccountSaveResponseDto 계좌등록(AccountSaveRequestDto accountSaveRequestDto){
        // 계좌가 DB에 있는지 중복 체크
        Optional<Account> accountOP =
                accountRepository.findByNumber(accountSaveRequestDto.getNumber());




    }

}
