package com.airlineticket.App.controller;


import com.airlineticket.App.models.flights.TripDetails;
import com.airlineticket.App.repos.TripDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookingController {


    @Autowired
    TripDetailsRepository tripDetailsRepository;

    @GetMapping("/booking/flight/{tripid}")
    public String bookingSelectedFlightPage(@PathVariable Integer tripid, Model model){


        TripDetails tripDetails = tripDetailsRepository.getReferenceById(tripid);

        System.out.println(tripDetails);

        model.addAttribute("selected_trip",tripDetails);

        return "booking/booking-selected-flight";
    }



    @GetMapping("/booking/flight/{selectedTripId}/{reservationId}/payment")
    public String bookingPaymentFlightPage(@PathVariable Integer selectedTripId,
                                           @PathVariable Integer reservationId
                                           ){


        return "booking/booking-payment";
    }

}
