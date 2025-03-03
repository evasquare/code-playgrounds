package com.evasquare.jwt_authentication.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.evasquare.jwt_authentication.repository.UserEntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userEntityRepository.findByUsername(username).orElseThrow();
        return UserPrincipal.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getHashedPassword())
                .authorities(List.of(new SimpleGrantedAuthority(user.getUserRole())))
                .build();
    }
}
