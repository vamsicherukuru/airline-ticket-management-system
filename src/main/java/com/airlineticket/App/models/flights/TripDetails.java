package com.airlineticket.App.models.flights;


import com.airlineticket.App.models.Airport;
import com.airlineticket.App.models.TripStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "trip_details")
@NoArgsConstructor
@AllArgsConstructor
public class TripDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "from_airport_id", nullable = false)
    private Airport from;

    @ManyToOne
    @JoinColumn(name = "to_airport_id", nullable = false)
    private Airport to;

    @Column(nullable = false)
    private Integer economy_price;

    @Column(nullable = false)
    private Integer first_price;

    @Column(nullable = false)
    private Integer business_price;


    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @Column(nullable = false)
    private Date date;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(nullable = false)
    private Time time;


    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private FlightDetails flightDetails;


    @Column(name = "trip_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private TripStatus trip_status = TripStatus.INACTIVE;




}
