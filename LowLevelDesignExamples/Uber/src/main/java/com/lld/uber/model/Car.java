package com.lld.uber.model;

import com.lld.uber.enums.CarType;
import com.lld.uber.enums.VehicleType;
import lombok.AllArgsConstructor;

public class Car extends Vehicle{
    private CarType carType;
    private double baseFee;
    private double perKmFee;

    public Car(CarType carType, double baseFee, double perKmFee,
               String name, VehicleType type, int capacity, String regNum,Location location) {
        super(name,type, capacity, regNum, location);
        this.carType = carType;
        this.baseFee = baseFee;
        this.perKmFee = perKmFee;
    }

    @Override
    public double getFare(double distance) {
        return baseFee + (perKmFee*distance);
    }
}
