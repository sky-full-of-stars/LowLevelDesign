package com.lld.elevatorsystem.service;

import com.lld.elevatorsystem.enums.ElevatorAllocationWays;

public class AllotElevatorFactory {

    public AllotElevatorService fetchElevatorAllocationService(ElevatorAllocationWays way)
    {
        switch (way)
        {
            case LEAST_WAIT_TIME_FIRST:
                return new LeastWaitTimeElevatorAllocationService();
            default:
                return new LeastWaitTimeElevatorAllocationService();
        }
    }
}
