package com.lld.parkinglot.strategy.impl;

import com.lld.parkinglot.exceptions.NoFreeSlotAvailableException;
import com.lld.parkinglot.model.Slot;
import com.lld.parkinglot.strategy.ParkingStrategy;

import java.util.TreeSet;

public class NaturalOrder implements ParkingStrategy {
    TreeSet<Integer> slots;

    public NaturalOrder() {
        this.slots = new TreeSet<>();
    }

    @Override
    public void addSlot(int slotNum) {
        slots.add(slotNum);
    }

    @Override
    public void removeSlot(int slotNum) {
        slots.remove(slotNum);
    }

    @Override
    public int nextSlot() {
        if(slots.isEmpty()) {
            throw new NoFreeSlotAvailableException();
        }
        return slots.first();
    }
}
