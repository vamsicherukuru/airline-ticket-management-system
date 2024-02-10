package com.airlineticket.App.repos;

import com.airlineticket.App.models.User;
import com.airlineticket.App.models.booking.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationsRepository extends JpaRepository<Reservations,Integer> {


    List<Reservations> findAllByUserId(User user);



}
