package com.airlineticket.App.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResetPasswordController {


    @GetMapping("/reset-password")
    public String passwordResetPage(

    ){



        return "auth/password-reset";
    }

}
