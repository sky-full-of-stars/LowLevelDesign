package com.lld.uber.service;

import com.lld.uber.model.Location;

public interface DistanceService {
    double getDistanceBetweenPoints(Location src, Location dest);
}
