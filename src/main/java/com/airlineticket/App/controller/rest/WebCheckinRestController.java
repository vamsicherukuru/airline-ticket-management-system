package com.airlineticket.App.controller.rest;


import com.airlineticket.App.models.User;
import com.airlineticket.App.models.booking.ReservationStatus;
import com.airlineticket.App.models.booking.Reservations;
import com.airlineticket.App.repos.FlightDetailsRepository;
import com.airlineticket.App.repos.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebCheckinRestController {



    @Autowired
    ReservationsRepository reservationsRepository;

    @PostMapping("/profile/checkin")
    public ResponseEntity<String> changeBPassStatus(@RequestParam String pnr_number){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        System.out.println(pnr_number);
        System.out.println(reservationsRepository.getReferenceById(Integer.parseInt(pnr_number.substring(2))));

        Reservations myreservation =reservationsRepository.getReferenceById(Integer.parseInt(pnr_number.substring(2)));
        if(myreservation.getUserId().getId()==user.getId() && myreservation.getReservation_status()== ReservationStatus.CONFIRMED){

            if(myreservation.getBoardingPassStatus()==null){
                myreservation.setBoardingPassStatus(false);
            }

            if (myreservation.getBoardingPassStatus()){
                return new ResponseEntity<>("Already Generated", HttpStatus.BAD_REQUEST);
            }


            myreservation.setBoardingPassStatus(true);
            reservationsRepository.save(myreservation);
            return new ResponseEntity<>("Web Check-IN Successful", HttpStatus.OK);
        }else{

            return new ResponseEntity<>("INVALID PNR", HttpStatus.BAD_REQUEST);

        }



    }

}
