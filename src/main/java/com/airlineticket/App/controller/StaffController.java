package com.airlineticket.App.controller;


import com.airlineticket.App.models.Airport;
import com.airlineticket.App.models.flights.FlightDetails;
import com.airlineticket.App.repos.AirportRepository;
import com.airlineticket.App.repos.FlightDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StaffController {



    @Autowired
    AirportRepository airportRepository;

    @Autowired
    FlightDetailsRepository flightDetailsRepository;

    @GetMapping("/staff/airports")
    public String airportPage(Model model){


        List<Airport> airportList= airportRepository.findAll();

        model.addAttribute("airports",airportList);

        return "staff/airports";

    }

    @GetMapping("/staff/flights")
    public String flightsPage(Model model){

        List<FlightDetails> flightDetails = flightDetailsRepository.findAll();
        model.addAttribute("flights",flightDetails);

        return "staff/flights";

    }

}
