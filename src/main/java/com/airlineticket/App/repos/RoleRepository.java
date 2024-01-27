package com.airlineticket.App.repos;

import com.airlineticket.App.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {


    Role findByName(String role);

}
