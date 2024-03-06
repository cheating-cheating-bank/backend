package com.example.bank.domain.account.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "account_tb")
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private Long number; //계좌번호

    @Column(nullable = false, length = 4)
    private Long password; //비밀번호

    @Column(nullable = false)
    private Long balance; //잔액

    @CreatedDate // insert
    @Column(updatable = false)
    private LocalDateTime createAt; // 생성일시

    @LastModifiedDate // Insert, update
    @Column
    private LocalDateTime updateAt; // 수정일시

    @Builder
    public Account(Long id,
                   Long number,
                   Long password,
                   Long balance,
                   LocalDateTime createAt,
                   LocalDateTime updateAt){
        this.id = id;
        this.number = number;
        this.password = password;
        this.balance = balance;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
