package com.airlineticket.App.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {


    @GetMapping("/")
    public String homePage(){

        return "home";
    }
    @GetMapping("/profile")
    public String profilePage(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getAuthorities().stream().anyMatch(auth->auth.getAuthority().equals("FLIGHT_OPERATIONS_MANAGER"))){
            return "staff/staff-profile-page";
        }
        else{
            return "user/profile-page";

        }


    }

    @GetMapping("/admin")
    public String adminPage(){

        return "home";
    }

}
