package com.lld.parkinglot.model;

import lombok.Data;

@Data
public class Slot {
    private int slotSize;
    private int slotNum;
    private boolean isFree;
    private Vehicle vehicle;

}
