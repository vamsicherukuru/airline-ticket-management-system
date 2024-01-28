package com.airlineticket.App.controller.rest;

import com.airlineticket.App.models.Role;
import com.airlineticket.App.models.User;
import com.airlineticket.App.repos.RoleRepository;
import com.airlineticket.App.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/save/user")
    public String createUser( @RequestParam String email,
                              @RequestParam String first_name,
                              @RequestParam String last_name,
                              @RequestParam String password) {
        System.out.println("Received registration request: " + email);
        // Create the USER role if not exists
        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }

        User myuser = new User();
        myuser.setEmail(email);
        myuser.setPassword(passwordEncoder.encode(password));
        myuser.setFirst_name(first_name);
        myuser.setLast_name(last_name);


        // Assign the USER role to the user
        myuser.setRoleList(Collections.singletonList(userRole));

        // Save the user
        userRepository.save(myuser);

        return "User created successfully!";
    }
}