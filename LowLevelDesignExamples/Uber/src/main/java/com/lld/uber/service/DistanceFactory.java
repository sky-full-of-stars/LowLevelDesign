package com.lld.uber.service;

import com.lld.uber.enums.DistanceCalculateMethod;

public class DistanceFactory {

    private static EucledianDistanceService eucledianDistanceService = new EucledianDistanceService();

    public DistanceService getDistanceService(DistanceCalculateMethod type) {
        if(DistanceCalculateMethod.EUCLIDEAN.equals(type)){
            return eucledianDistanceService;
        }
        return null;
    }
}
