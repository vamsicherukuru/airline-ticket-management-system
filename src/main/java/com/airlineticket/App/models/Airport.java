package com.airlineticket.App.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "airports")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airport {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "airport_name", nullable = false)
    private String airport_name;

    @Column(name = "airport_code", unique = true, nullable = false)
    private String airport_code;

    @Column(name = "city",nullable = false)
    private String city;

    @Override
    public String toString() {
        return airport_name +" (" + airport_code +")";
    }
}
