package com.airlineticket.App.repos;

import com.airlineticket.App.models.booking.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {



}
