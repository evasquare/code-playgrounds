package com.evasquare.jwt_authentication.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtToPrincipalConverter {
    public UserPrincipal convert(DecodedJWT jwt) {
        var authorityList = getClaimOrEmptyList(jwt, "authorities").stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        return UserPrincipal.builder()
                .id(Long.parseLong(jwt.getSubject()))
                .username(jwt.getClaim("username").asString())
                .authorities(authorityList)
                .build();
    }

    public List<String> getClaimOrEmptyList(DecodedJWT jwt, String claim) {
        if (jwt.getClaim(claim).isNull()) {
            return List.of();
        }

        // The String.class in jwt.getClaim(claim).asList(String.class) is used to
        // specify the expected type of the elements in the list when extracting the
        // claim from the JWT.
        return jwt.getClaim(claim).asList(String.class);
    }
}
