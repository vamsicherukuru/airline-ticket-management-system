package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.Airport;
import com.airlineticket.App.models.TripStatus;
import com.airlineticket.App.models.flights.FlightDetails;
import com.airlineticket.App.models.flights.TripDetails;
import com.airlineticket.App.repos.TripDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@RestController
public class TripsRestController {


    @Autowired
    private TripDetailsRepository tripDetailsRepository;

    @PostMapping("/staff/trips")
    public String createTrip(
            @RequestParam Integer business_price,
            @RequestParam Integer economy_price,
            @RequestParam Integer first_price,
            @RequestParam String time,
            @RequestParam String date,
            @RequestParam FlightDetails flight_id,
            @RequestParam Airport from,
            @RequestParam Airport to,
            @RequestParam TripStatus trip_status

            ){

        TripDetails newTrip = new TripDetails();
        newTrip.setTrip_status(trip_status);
        newTrip.setTo(to);
        newTrip.setFrom(from);
        newTrip.setBusiness_price(business_price);
        newTrip.setEconomy_price(economy_price);
        newTrip.setFirst_price(first_price);
        newTrip.setDate(Date.valueOf(date));
        newTrip.setTime(Time.valueOf(LocalTime.parse(time)));
        newTrip.setFlightDetails(flight_id);

        System.out.println(newTrip);

        tripDetailsRepository.save(newTrip);


        return "Trip Created Successfully";
    }


}
