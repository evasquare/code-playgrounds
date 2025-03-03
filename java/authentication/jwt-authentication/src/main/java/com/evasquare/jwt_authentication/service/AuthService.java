package com.evasquare.jwt_authentication.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.evasquare.jwt_authentication.model.LoginResponse;
import com.evasquare.jwt_authentication.security.JwtIssuer;
import com.evasquare.jwt_authentication.security.UserPrincipal;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
        private final JwtIssuer jwtIssuer;
        private final AuthenticationManager authenticationManager;

        public LoginResponse attemptLogin(String username, String password) {

                var authentication = authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(username, password));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                var principal = (UserPrincipal) authentication.getPrincipal();

                var token = jwtIssuer.issue(JwtIssuer.Request.builder()
                                .id(principal.getId())
                                .username(principal.getUsername())
                                .roles(principal.getAuthorities().stream()
                                                .map(GrantedAuthority::getAuthority).toList())
                                .build());

                return LoginResponse.builder()
                                .token(token)
                                .build();
        }
}
