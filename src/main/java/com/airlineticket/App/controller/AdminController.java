package com.airlineticket.App.controller;


import com.airlineticket.App.models.Role;
import com.airlineticket.App.models.User;
import com.airlineticket.App.models.UserRole;
import com.airlineticket.App.models.booking.Reservations;
import com.airlineticket.App.repos.ReservationsRepository;
import com.airlineticket.App.repos.RoleRepository;
import com.airlineticket.App.repos.UserRepository;
import com.airlineticket.App.repos.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    ReservationsRepository reservationsRepository;


    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;




    @GetMapping("/admin")
    public String adminHomePage(Model model){


        List<Reservations> allBookings = reservationsRepository.findAll();

        model.addAttribute("allBookings", allBookings);


        return "admin/admin-home";
    }


    @GetMapping("/admin/staff-management")
    public String adminStaffManagementPage(Model model){


        List<UserRole> allusers = userRoleRepository.findAllByRole_Id(2);

        model.addAttribute("allusers", allusers);
        System.out.println(allusers);


        return "admin/admin-staff-management";
    }





    @PostMapping("/admin/staff-management/add/user")
    public String addUserAdminPage(@RequestParam String first_name,
                                   @RequestParam String last_name,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   @RequestParam String roles
                                   ){


        System.out.println("Received registration request: " + email);
        Role userRole = null;
        if (roles.equals("2")) {
            userRole = roleRepository.findByName("FLIGHT_OPERATIONS_MANAGER");
        } else if (roles.equals("3")) {
            userRole = roleRepository.findByName("ADMIN");
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






        return "redirect:/admin/staff-management";

    }

}
