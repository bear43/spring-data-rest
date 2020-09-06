package com.example.demo.service;

import com.example.demo.exception.keycloak.NonKeyCloakAuthenticationUsedException;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String getTokenString(Authentication authentication) {
        if(authentication instanceof KeycloakAuthenticationToken) {
            return ((KeycloakAuthenticationToken) authentication).getAccount().getKeycloakSecurityContext().getTokenString();
        }
        throw new NonKeyCloakAuthenticationUsedException();
    }
}
