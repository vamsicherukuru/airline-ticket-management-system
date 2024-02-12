package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.User;
import com.airlineticket.App.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ResetPasswordRestController {


    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/reset-password/api")
    public ResponseEntity<String> resetPasswordAPI(
            @RequestParam String email,
            @RequestParam String newPassword
    ){
        System.out.println(email);
        System.out.println(newPassword);

        String newBcryptedPassword = passwordEncoder.encode(newPassword);


        User getUser = userRepository.findByEmail(email);
        String oldPassword = getUser.getPassword();
        System.out.println(oldPassword);

        if (passwordEncoder.matches(newPassword, oldPassword)) {
            // Passwords match
            System.out.println("Passwords Match, Can't Change.");
            return new ResponseEntity<String>("Passwords Match, Can't Change", HttpStatus.BAD_REQUEST);


        }else{
            System.out.println(newBcryptedPassword);
            getUser.setPassword(newBcryptedPassword);
            userRepository.save(getUser);
            return new ResponseEntity<String>("Password Reset Done", HttpStatus.OK);
        }





    }

}
