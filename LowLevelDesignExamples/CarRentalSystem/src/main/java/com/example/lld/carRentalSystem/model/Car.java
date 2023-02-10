package com.example.lld.carRentalSystem.model;

import com.example.lld.carRentalSystem.enums.CarType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode (callSuper = true)
@Data
public class Car extends Vehicle{
    private CarType carType;

}
