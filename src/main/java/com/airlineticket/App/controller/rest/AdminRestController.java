package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.User;
import com.airlineticket.App.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {


    @Autowired
    UserRepository userRepository;

    @PostMapping("/admin/api/disable/user/{userId}")
    public ResponseEntity<String> disableUser(@PathVariable Integer userId){


        System.out.println(userId);


        User user = userRepository.getReferenceById(userId);

        user.setEnabled(false);
        userRepository.save(user);



        return new ResponseEntity<>("User Disabled", HttpStatus.OK);



    }

    @PostMapping("/admin/api/enable/user/{userId}")
    public ResponseEntity<String> enableUser(@PathVariable Integer userId){


        System.out.println(userId);


        User user = userRepository.getReferenceById(userId);

        user.setEnabled(true);
        userRepository.save(user);



        return new ResponseEntity<>("User Enabled", HttpStatus.OK);



    }


}
