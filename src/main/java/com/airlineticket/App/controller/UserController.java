package com.airlineticket.App.controller;


import com.airlineticket.App.models.Airport;
import com.airlineticket.App.models.User;
import com.airlineticket.App.models.booking.Reservations;
import com.airlineticket.App.repos.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    ReservationsRepository reservationsRepository;



    @GetMapping("/profile/mytickets")
    public String myTicketsPage(){
        
        return "user/my-tickets";

    }

    @GetMapping("/profile/booking-history")
    public String bookingHistoryPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();


        List<Reservations> myreservations = reservationsRepository.findAllByUserId(user);

        model.addAttribute("myreservations",myreservations);


        return "user/booking-history";

    }


}
