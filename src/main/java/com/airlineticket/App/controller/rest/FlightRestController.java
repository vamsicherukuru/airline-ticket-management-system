package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.flights.FlightDetails;
import com.airlineticket.App.repos.FlightDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightRestController {



    @Autowired
    FlightDetailsRepository flightDetailsRepository;


    @PostMapping("/staff/flights")
    public String addFlight(
            @RequestParam String flight_no,
            @RequestParam String operator,
            @RequestParam Integer economy_seats,
            @RequestParam Integer first_seats,
            @RequestParam Integer business_seats


    ){


        FlightDetails newFlight = new FlightDetails();

        newFlight.setFlight_no(flight_no);
        newFlight.setOperator(operator);
        newFlight.setBusiness_seats(business_seats);
        newFlight.setFirst_seats(first_seats);
        newFlight.setEconomy_seats(economy_seats);

        flightDetailsRepository.save(newFlight);

        return "Flight Added Successfully";



    }
}
