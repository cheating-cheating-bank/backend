package com.example.bank.domain.user.entity;

import com.example.bank.global.utils.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String fullname;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING) //Enum 이름을 DB에 저장
    private UserRoleEnum role;



}
