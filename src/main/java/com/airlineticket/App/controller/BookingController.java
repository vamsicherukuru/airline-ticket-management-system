package com.airlineticket.App.controller;


import com.airlineticket.App.models.booking.Reservations;
import com.airlineticket.App.models.booking.SeatClass;
import com.airlineticket.App.models.flights.TripDetails;
import com.airlineticket.App.repos.ReservationsRepository;
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

    @Autowired
    ReservationsRepository reservationsRepository;

    @GetMapping("/booking/flight/{tripid}")
    public String bookingSelectedFlightPage(@PathVariable Integer tripid, Model model){


        TripDetails tripDetails = tripDetailsRepository.getReferenceById(tripid);

        System.out.println(tripDetails);

        model.addAttribute("selected_trip",tripDetails);

        return "booking/booking-selected-flight";
    }



    @GetMapping("/booking/flight/{selectedTripId}/{reservationId}/payment")
    public String bookingPaymentFlightPage(@PathVariable Integer selectedTripId,
                                           @PathVariable Integer reservationId,
                                           Model model
                                           ){

        TripDetails trip = tripDetailsRepository.getReferenceById(selectedTripId);
        Reservations reservation = reservationsRepository.getReferenceById(reservationId);

        Integer total_amount=0;
        if(reservation.getSeat_class()== SeatClass.BUSINESS){

            total_amount = reservation.getPassengercount() * trip.getBusiness_price();

        } else if (reservation.getSeat_class()==SeatClass.FIRST_CLASS) {
            total_amount = reservation.getPassengercount() * trip.getFirst_price();

        }
        else if(reservation.getSeat_class()==SeatClass.ECONOMY) {
            total_amount = reservation.getPassengercount() * trip.getEconomy_price();

        }
        model.addAttribute("selected_trip",selectedTripId)
                .addAttribute("reservation_id",reservationId)
                .addAttribute("total_amount",total_amount);


        return "booking/booking-payment";
    }

}
