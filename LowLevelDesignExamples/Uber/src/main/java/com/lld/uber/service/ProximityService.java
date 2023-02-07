package com.lld.uber.service;

import com.lld.uber.enums.DistanceCalculateMethod;
import com.lld.uber.enums.DriverStatus;
import com.lld.uber.model.Driver;
import com.lld.uber.model.Location;

import java.util.List;
import java.util.stream.Collectors;

public class ProximityService {

    DriverService driverService;

    public ProximityService(DriverService service) {
        driverService = service;
    }

    public List<Driver> getDriversInRadiusOfLocation(Location center, int radius) {
        final List<Driver> driverList = driverService.getDriverList();
        //DistanceFactory distanceFactory = new DistanceFactory();
        return driverList.stream().filter(x -> x.getStatus().equals(DriverStatus.ACTIVELY_LOOKING)).filter(driver -> {
                    double distanceOfDriver = DistanceFactory.getDistanceService(DistanceCalculateMethod.EUCLIDEAN).getDistanceBetweenPoints(driver.getVehicle().getLocation(), center);
                    return distanceOfDriver <= radius;
                }
        ).collect(Collectors.toList());
    }

}
