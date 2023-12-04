package com.leeonscoding.keycloakdemo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/admin")
    public String helloAdmin(@AuthenticationPrincipal Jwt jwt) {
        StringBuilder sb = new StringBuilder();
        jwt.getClaims().forEach((key, value) -> {
            sb.append(key + " : "+value + "\n");
        });
        return "Hello world : " + sb;
    }

    @GetMapping("/user")
    public String helloUser(@AuthenticationPrincipal Jwt jwt) {
        StringBuilder sb = new StringBuilder();
        jwt.getClaims().forEach((key, value) -> {
            sb.append(key + " : "+value);
        });
        return "Hello world : " + sb;
    }
}
