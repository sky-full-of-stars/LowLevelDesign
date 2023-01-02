package com.lld.uber.service;

import com.lld.uber.model.Location;

public class EucledianDistanceService implements DistanceService{

    @Override
    public double getDistanceBetweenPoints(Location src, Location dest) {
        int x1 = src.getXCoordinate();
        int y1 = src.getYCoordinate();
        int x2 = dest.getXCoordinate();
        int y2 = dest.getYCoordinate();
        return Math.sqrt(getSquareOfNumber(x2-x1) + getSquareOfNumber(y2-y1));
    }
    private int getSquareOfNumber(int num) {
        return num*num;
    }
}
