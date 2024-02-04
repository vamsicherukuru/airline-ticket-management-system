package com.airlineticket.App.repos;

import com.airlineticket.App.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {



}
