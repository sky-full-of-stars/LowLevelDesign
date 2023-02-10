package com.example.lld.carRentalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Store {
    private int id;
    private String name;
    private VehicleInventory inventory;
    private Location location;
    private List<Reservation> reservations;
}
