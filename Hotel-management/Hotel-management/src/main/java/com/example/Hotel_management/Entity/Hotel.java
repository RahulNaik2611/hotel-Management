package com.example.Hotel_management.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Hotel
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String Name;

    private String address;

    private String city;

    private  int postalCode;

    private float rating;

    @Column(name = "available")
    private boolean isAvailable;

}
