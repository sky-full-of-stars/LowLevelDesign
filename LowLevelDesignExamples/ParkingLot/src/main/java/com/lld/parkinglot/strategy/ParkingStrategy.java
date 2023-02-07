package com.lld.parkinglot.strategy;

import com.lld.parkinglot.model.Slot;

import java.util.List;

public interface ParkingStrategy {
    public void addSlot(int slotNum);

    public void removeSlot(int slotNum);

    public int nextSlot();
}
