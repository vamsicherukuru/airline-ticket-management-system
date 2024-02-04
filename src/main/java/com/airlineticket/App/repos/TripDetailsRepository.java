package com.airlineticket.App.repos;


import com.airlineticket.App.models.flights.TripDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDetailsRepository extends JpaRepository<TripDetails, Integer> {

}
