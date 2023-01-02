package com.lld.uber.service;

import com.lld.uber.enums.DistanceCalculateMethod;
import com.lld.uber.enums.RideStatus;
import com.lld.uber.enums.RideType;
import com.lld.uber.model.Driver;
import com.lld.uber.model.Location;
import com.lld.uber.model.Ride;
import com.lld.uber.model.Rider;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class TripService {

    private List<Ride> rideList = new ArrayList<>();
    void registerRide(Ride ride) {
        rideList.add(ride);
    }

    public Ride createNewSoloRide(Location source, Location destination, Rider rider, List<Driver> nearByDrivers) {
        Ride ride = new Ride();
        ride.setRideStatus(RideStatus.TO_START);
        ride.setRiderList(List.of(rider));
        ride.setRideType(RideType.SOLO);
        ride.setDateTime(Date.from(Instant.now()));
        Driver driver = nearByDrivers.get(0);
        ride.setDriver(driver);
        double distance = new DistanceFactory().getDistanceService(DistanceCalculateMethod.EUCLIDEAN).getDistanceBetweenPoints(source, destination);
        ride.setFare(FareService.calculateFare(driver.getVehicle(), distance));
        ride.setSource(source);
        ride.setDestination(destination);
        return ride;
    }
}
