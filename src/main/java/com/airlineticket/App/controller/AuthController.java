package com.airlineticket.App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AuthController {
    @GetMapping("/login")
    public String loginPage(){

        return "auth/login";
    }
    @GetMapping("/register")
    public String signupPage(){

        return "auth/register";
    }
}
