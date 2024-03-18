package com.example.bank.global.exception.ex;


import lombok.Getter;

@Getter
public class CustomApiException extends RuntimeException{
    public CustomApiException(String s) {
        super(s);
    }


}
