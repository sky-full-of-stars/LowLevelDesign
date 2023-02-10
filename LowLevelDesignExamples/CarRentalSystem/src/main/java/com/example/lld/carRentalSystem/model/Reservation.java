package com.example.lld.carRentalSystem.model;

import com.example.lld.carRentalSystem.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    private int id;
    private Member person;
    private Vehicle vehicle;
    private Date from;
    private Date to;
    private Location pickupLocation;
    private Location dropLocation;
    private ReservationStatus status;


    public Reservation reserveVehicle(Vehicle vehicle,Member person, Date from, Date to,Location pickupLocation, Location dropLocation ){
        Random rand = new Random();
        return new Reservation(rand.nextInt(1000), person, vehicle, from, to, pickupLocation, dropLocation, ReservationStatus.RESERVED);
    }
}
