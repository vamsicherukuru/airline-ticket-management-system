package com.airlineticket.App.repos;

import com.airlineticket.App.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
