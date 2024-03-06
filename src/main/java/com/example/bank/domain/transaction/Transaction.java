package com.example.bank.domain.transaction;


import com.example.bank.domain.account.entity.Account;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "transaction_tb")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long amount; //입출금 금액

    @ManyToOne(fetch = FetchType.LAZY)
    private Account withdrawAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account depositAccount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionEnum gubun;


    private Long withdrawAccountBalance; // 잔액변화

    private Long depositAccountBalance;

    // 계좌가 사라져도 로그 남기기
    private String sender;
    private String receiver;
    private String tel;

    @CreatedDate // insert
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // insert, update
    @Column(nullable = false)
    private LocalDateTime updateAt;

    @Builder
    public Transaction(Long id,
                       Account withdrawAccount,
                       Account depositAccount,
                       Long amount,
                       Long withdrawAccountBalance,
                       Long depositAccountBalance,
                       String sender,
                       String receiver,
                       String tel,
                       LocalDateTime createdAt,
                       LocalDateTime updateAt
                       ) {
        this.id = id;
        this.withdrawAccount = withdrawAccount;
        this.depositAccount = depositAccount;
        this.amount = amount;
        this.withdrawAccountBalance = withdrawAccountBalance;
        this.depositAccountBalance = depositAccountBalance;
        this.sender = sender;
        this.receiver = receiver;
        this.tel = tel;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
