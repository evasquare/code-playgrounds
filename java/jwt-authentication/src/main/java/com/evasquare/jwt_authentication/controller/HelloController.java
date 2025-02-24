package com.evasquare.jwt_authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evasquare.jwt_authentication.repository.UserEntityRepository;
import com.evasquare.jwt_authentication.security.UserPrincipal;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    @Autowired
    UserEntityRepository userEntityRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello, world! This is public to everyone";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        // return userEntityRepository.findById(1L).toString();
        return "Everyone can see this";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {
        return "This can only be seen by a logged in user. Your Email is: "
                + principal.getUsername() + " your ID: " + principal.getId();
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal principal) {
        return "If you see this, you are an admin. Your ID: " + principal.getId();
    }

    @GetMapping("/count")
    public String getCount() {
        return userEntityRepository.findAll().size() + "";
    }

}
