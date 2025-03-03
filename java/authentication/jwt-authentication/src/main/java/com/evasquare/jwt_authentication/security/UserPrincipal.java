package com.evasquare.jwt_authentication.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserPrincipal implements UserDetails {
    private final Long id;
    private final String username;

    @JsonIgnore
    private final String password;

    private final List<? extends GrantedAuthority> authorities;
}
