package com.lld.parkinglot.model;

import com.lld.parkinglot.enums.CarType;
import com.lld.parkinglot.enums.Color;

public class Car extends Vehicle{
    private CarType carType;

    public Car(String name, String registrationNum, Color color) {
        super(name, registrationNum, color);
    }
}
