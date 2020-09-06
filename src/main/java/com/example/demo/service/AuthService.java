package com.example.demo.service;

import org.springframework.security.core.Authentication;

public interface AuthService {
    String getTokenString(Authentication authentication);
}
