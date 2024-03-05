package com.example.bank.domain.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long number; //계좌번호

    @Column
    private Long password; //비밀번호

    @Column
    private Long balance; //잔액

    @Column
    private LocalDateTime createAt; // 생성일시

    @Column
    private LocalDateTime datetime; // 수정일시

}
