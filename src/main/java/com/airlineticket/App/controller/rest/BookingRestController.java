package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.User;
import com.airlineticket.App.models.booking.*;
import com.airlineticket.App.models.flights.TripDetails;
import com.airlineticket.App.repos.ReservationsRepository;
import com.airlineticket.App.repos.TransactionRepository;
import com.airlineticket.App.repos.TripDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingRestController {


    @Autowired
    ReservationsRepository reservationsRepository;

    @Autowired
    TransactionRepository transactionRepository;


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
        currentReservation.setUserId(user);

        System.out.println(currentReservation);

        Reservations savedReservation = reservationsRepository.save(currentReservation);

        return  savedReservation.getId();
    }





    @PostMapping("/booking/flight/{selected_trip}/{reservation_id}/payment")
    public String paymentInfoPage(
            @PathVariable Integer selected_trip,
            @PathVariable Integer reservation_id,
            @RequestParam String card_number,
            @RequestParam String name_on_card,
            @RequestParam String expiry_date,
            @RequestParam String cvv,
            @RequestParam String street_address,
            @RequestParam String address_2,
            @RequestParam String billing_city,
            @RequestParam String billing_country,
            @RequestParam String billing_zipcode,
            @RequestParam Double total_amount

            ){

        Transaction mytransaction = new Transaction();
        TripDetails trip = tripDetailsRepository.getReferenceById(selected_trip);
        Reservations reservation = reservationsRepository.getReferenceById(reservation_id);


        mytransaction.setCvv(cvv);
        mytransaction.setAddress_2(address_2);
        mytransaction.setTrip_id(trip);
        mytransaction.setReservation_id(reservation);
        mytransaction.setStreet_address(street_address);
        mytransaction.setExpiry_date(expiry_date);
        mytransaction.setName_on_card(name_on_card);
        mytransaction.setCard_number(card_number);
        mytransaction.setBilling_city(billing_city);
        mytransaction.setBilling_country(billing_country);
        mytransaction.setBilling_zipcode(billing_zipcode);
        mytransaction.setTotal_amount(total_amount);
        mytransaction.setPayment_status(PaymentStatus.PAID);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        mytransaction.setUser_id(user);

        reservation.setPayment_status(PaymentStatus.PAID);

        reservation.setReservation_status(ReservationStatus.CONFIRMED);



        System.out.println(mytransaction);


        System.out.println(reservation.getPassengercount()+"------------"+reservation.getSeat_class());

        transactionRepository.save(mytransaction);
        reservationsRepository.save(reservation);




        return "payment successful";
    }






}
