package com.lld.elevatorsystem.service;

import com.lld.elevatorsystem.enums.ElevatorAllocationWays;

public class AllotElevatorFactory {

    public AllotElevatorService fetchElevatorAllocationService(ElevatorAllocationWays way)
    {
        switch (way)
        {
            case NEAREST_FIRST :
                return new NearestElevatorAllocationService();
            default:
                return new NearestElevatorAllocationService();
        }
    }
}
