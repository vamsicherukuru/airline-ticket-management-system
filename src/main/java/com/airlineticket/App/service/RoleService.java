package com.airlineticket.App.service;


import com.airlineticket.App.models.Role;
import com.airlineticket.App.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(){
        Role role= new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }


}
