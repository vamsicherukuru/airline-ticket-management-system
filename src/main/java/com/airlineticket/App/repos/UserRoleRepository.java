package com.airlineticket.App.repos;


import com.airlineticket.App.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    List<UserRole> findAllByRole_Id(Integer roleId);

}
