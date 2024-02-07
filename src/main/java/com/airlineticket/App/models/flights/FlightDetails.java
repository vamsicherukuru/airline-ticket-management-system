package com.airlineticket.App.models.flights;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "flight_details")
@NoArgsConstructor
@AllArgsConstructor
public class FlightDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "flight_no", unique = true, nullable = false)
    private String flight_no;

    @Column(name = "operator", nullable = false)
    private String operator;

    @Column(name = "economy_seats", nullable = false)
    private Integer economy_seats;

    @Column(name = "first_seats", nullable = false)
    private Integer first_seats;

    @Column(name = "business_seats", nullable = false)
    private Integer business_seats;







}
