package com.airlineticket.App.controller;


import com.airlineticket.App.models.Airport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @GetMapping("/profile/mytickets")
    public String myTicketsPage(){
        
        return "user/my-tickets";

    }

    @GetMapping("/profile/booking-history")
    public String bookingHistoryPage(){

        return "user/booking-history";

    }


}
