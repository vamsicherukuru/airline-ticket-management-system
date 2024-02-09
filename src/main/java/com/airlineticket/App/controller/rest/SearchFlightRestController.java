package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.Airport;
import com.airlineticket.App.models.flights.TripDetails;
import com.airlineticket.App.repos.AirportRepository;
import com.airlineticket.App.repos.FlightDetailsRepository;
import com.airlineticket.App.repos.TripDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
public class SearchFlightRestController {



    @Autowired
    TripDetailsRepository tripDetailsRepository;

    @Autowired
    AirportRepository airportRepository;

    @GetMapping("/search/flights")
    public List<TripDetails> getFlights(@RequestParam Integer arrival,
                                        @RequestParam Integer departure,
                                        @RequestParam Date travel_date,
                                        Model model
                                        ){


        System.out.println(travel_date);
        Airport departure_apt = airportRepository.getReferenceById(departure);

        Airport arrival_apt = airportRepository.getReferenceById(arrival);

        System.out.println(departure_apt);
        System.out.println(arrival_apt);
        List<TripDetails> availableFlights = tripDetailsRepository.findAllByFromAndToAndDate(departure_apt,arrival_apt,travel_date);

        System.out.println(availableFlights);


        model.addAttribute("responses",availableFlights);

        return availableFlights;

    }



}
