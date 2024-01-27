package com.airlineticket.App.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {


    @GetMapping("/")
    public String homePage(){

        return "home";
    }

}
