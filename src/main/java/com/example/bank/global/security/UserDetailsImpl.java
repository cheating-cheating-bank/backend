package com.example.bank.global.security;

import com.example.bank.domain.user.entity.User;
import com.example.bank.domain.user.entity.UserRoleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    private final User user;

    public UserDetailsImpl(User user){
        this.user = user;
    }

    public User getUser(){return user;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserRoleEnum role = user.getRole();
        String authority = role.getAuthority();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;
    }

    @Override
    @JsonProperty
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @JsonProperty
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    } //계정 만료 여부 반환

    @Override
    public boolean isAccountNonLocked() {
        return true;
    } //계정 잠금 여부 반환

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } //패스워드 완료 여부 반환

    @Override
    public boolean isEnabled() {
        return true;
    } // 계정 사용가능 여부 반환
}
