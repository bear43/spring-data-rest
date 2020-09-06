package com.example.demo.exception.keycloak;

public class NonKeyCloakAuthenticationUsedException extends RuntimeException {
    public NonKeyCloakAuthenticationUsedException() {
        super("Used not Keycloak authentication");
    }
}
