package com.example.bank.domain.account.sevice;

import com.example.bank.domain.account.dto.AccountSaveRequestDto;
import com.example.bank.domain.account.dto.AccountSaveResponseDto;
import com.example.bank.domain.account.entity.Account;
import com.example.bank.domain.account.repository.AccountRepository;
import com.example.bank.global.exception.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public AccountSaveResponseDto 계좌등록(AccountSaveRequestDto accountSaveRequestDto,Long userId){
        // User가 존재하는 지 확인


        // 계좌가 DB에 있는지 중복 체크
        Optional<Account> accountOP =
                accountRepository.findByNumber(accountSaveRequestDto.getNumber());
        if(accountOP.isPresent()) {
            throw new CustomApiException("해당 계좌가 이미 존재합니다.");
        }



        //계좌 등록


        return null;
    }

}


