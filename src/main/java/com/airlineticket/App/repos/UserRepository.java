package com.airlineticket.App.repos;

import com.airlineticket.App.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
