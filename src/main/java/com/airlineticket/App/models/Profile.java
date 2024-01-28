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

    @Column(name = "")
    private Integer age;

    @Column(name = "")
    private String address;

    @Column(name = "")
    private String aptNo;

    @Column(name = "")
    private String city;

    @Column(name = "")
    private String state;

    @Column(name = "")
    private String country;

    @Column(name = "")
    private String zipcode;

    @Column(name = "user_email")
    private String user_email;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    // Getter and Setter methods

    // Other fields and methods as needed
}