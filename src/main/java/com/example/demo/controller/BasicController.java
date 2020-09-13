package com.example.demo.controller;

import com.example.demo.exception.keycloak.NonKeyCloakAuthenticationUsedException;
import com.example.demo.service.AuthService;
/*import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Controller
//@PreAuthorize("isAuthenticated()")
public class BasicController {

    private final AuthService authService;

    public BasicController(AuthService authService) {
        this.authService = authService;
    }

/*    @GetMapping("/token")
    @ResponseBody
    public String getToken(Authentication authentication) {

        return authService.getTokenString(authentication);
    }*/

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }
}
