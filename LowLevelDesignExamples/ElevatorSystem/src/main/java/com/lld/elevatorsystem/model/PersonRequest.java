package com.lld.elevatorsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonRequest {
    private String name;
    private int arrivingTime;
    private int fromFloor;
    private int toFloor;
}
