package com.lld.parkinglot.model;


import com.lld.parkinglot.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private String name;
    private String registrationNum;
    private Color color;

}
