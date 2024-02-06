package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.User;
import com.airlineticket.App.models.booking.Reservations;
import com.airlineticket.App.models.booking.SeatClass;
import com.airlineticket.App.models.flights.TripDetails;
import com.airlineticket.App.repos.ReservationsRepository;
import com.airlineticket.App.repos.TripDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingRestController {


    @Autowired
    ReservationsRepository reservationsRepository;


    @Autowired
    TripDetailsRepository tripDetailsRepository;

    @PostMapping("/booking/flight/reservation")
    public Integer reserveInfoPage(@RequestParam Integer passenger_count,
                                  @RequestParam String seat_class,
                                  @RequestParam String passport_country,
                                  @RequestParam String passport_number,
                                  @RequestParam String primary_passenger_name,
                                  @RequestParam Integer primary_passenger_age,
                                  @RequestParam String primary_passenger_number,
                                  @RequestParam String primary_passenger_email,
                                  @RequestParam TripDetails selected_trip
                                  ){

        Reservations currentReservation = new Reservations();
        currentReservation.setPassengercount(passenger_count);
        currentReservation.setPassport_country(passport_country);
        currentReservation.setPassport_number(passport_number);
        currentReservation.setPrimary_passenger_name(primary_passenger_name);
        currentReservation.setPrimary_passenger_age(primary_passenger_age);
        currentReservation.setPrimary_passenger_email(primary_passenger_email);
        currentReservation.setPrimary_passenger_number(primary_passenger_number);
        currentReservation.setSeat_class(SeatClass.valueOf(seat_class));
        currentReservation.setTrip_id(selected_trip);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        currentReservation.setUser_id(user);

        System.out.println(currentReservation);

        Reservations savedReservation = reservationsRepository.save(currentReservation);

        return  savedReservation.getId();
    }

}
