package com.airlineticket.App.controller.rest;

import com.airlineticket.App.models.Role;
import com.airlineticket.App.models.User;
import com.airlineticket.App.repos.RoleRepository;
import com.airlineticket.App.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/api/users")
    public String createUser(@RequestBody User user) {
        // Create the USER role if not exists
        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");
            roleRepository.save(userRole);
        }

        // Assign the USER role to the user
        user.setRoleList(Collections.singletonList(userRole));

        // Save the user
        userRepository.save(user);

        return "User created successfully!";
    }
}