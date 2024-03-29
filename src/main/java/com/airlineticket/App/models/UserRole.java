package com.airlineticket.App.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "spring_security_user_role_list")
@Getter
@Setter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields (user, role) and getters/setters
    // Add reference to Role
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Add reference to User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}