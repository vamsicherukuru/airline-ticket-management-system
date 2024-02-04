package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.Airport;
import com.airlineticket.App.repos.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportRestController {


    @Autowired
    AirportRepository airportRepository;


    @PostMapping("/staff/airports")
    public String addAirport(
            @RequestParam String airport_name,
            @RequestParam String airport_code,
            @RequestParam String city
    ){


        Airport newAirport = new Airport();
        newAirport.setAirport_code(airport_code);
        newAirport.setAirport_name(airport_name);
        newAirport.setCity(city);


        airportRepository.save(newAirport);


        return "Airport Added Successfully";



    }


}
