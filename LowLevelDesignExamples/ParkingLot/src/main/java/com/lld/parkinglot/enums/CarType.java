package com.lld.parkinglot.enums;

public enum CarType {
    MICRO(1), SEDAN(2), HATCHBACK(2), SUV(3), LIMO(4), MINIVAN(5), MINIBUS(6);
    int carSize;
    CarType(int size) {
        this.carSize = size;
    }

}
