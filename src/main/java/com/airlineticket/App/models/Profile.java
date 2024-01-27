package com.airlineticket.App.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private Integer age;
    private String address;
    private String aptNo;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private String user_email;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    // Getter and Setter methods

    // Other fields and methods as needed
}