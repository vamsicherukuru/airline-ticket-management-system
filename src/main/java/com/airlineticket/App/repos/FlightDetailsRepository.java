package com.airlineticket.App.repos;

import com.airlineticket.App.models.flights.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails,Integer> {


}
