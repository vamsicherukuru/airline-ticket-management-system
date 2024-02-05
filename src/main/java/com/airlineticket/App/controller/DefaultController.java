package com.airlineticket.App.controller;


import com.airlineticket.App.models.Airport;
import com.airlineticket.App.models.flights.FlightDetails;
import com.airlineticket.App.models.flights.TripDetails;
import com.airlineticket.App.repos.AirportRepository;
import com.airlineticket.App.repos.TripDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    TripDetailsRepository tripDetailsRepository;

    @GetMapping("/")
    public String homePage(Model model){
        List<Airport> airports = airportRepository.findAll();
        List<TripDetails> trips = tripDetailsRepository.findAll();
        model.addAttribute("airports",airports);
        model.addAttribute("trips",trips);
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
