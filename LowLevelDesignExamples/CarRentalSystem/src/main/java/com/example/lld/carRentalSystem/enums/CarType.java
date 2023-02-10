package com.example.lld.carRentalSystem.enums;

import lombok.Data;

public enum CarType {
    HATCHBACK(4), SUV(5), SEDAN(6);
    int numOfSeats;

    CarType(int seats) {
        this.numOfSeats = seats;
    }

}
