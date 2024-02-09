package com.airlineticket.App.repos;


import com.airlineticket.App.models.Airport;
import com.airlineticket.App.models.flights.TripDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TripDetailsRepository extends JpaRepository<TripDetails, Integer> {



    List<TripDetails> findAllByFromAndToAndDate(Airport from, Airport to, Date date);

}
