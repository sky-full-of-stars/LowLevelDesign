package com.lld.uber;

import com.lld.uber.enums.CarType;
import com.lld.uber.enums.DriverStatus;
import com.lld.uber.enums.VehicleType;
import com.lld.uber.model.*;
import com.lld.uber.service.DriverService;
import com.lld.uber.service.ProximityService;
import com.lld.uber.service.RiderService;
import com.lld.uber.service.TripService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UberApplication {
    //responsibility of this class is
    //take inputs of vehicles, riders, drivers..... so on

    //ask what service is needed and serve that request( eg: book cab here)
    //playGame() in chess or snake&Ladder

    public static void main(String[] args) {
        SpringApplication.run(UberApplication.class, args);
        Location location1 = new Location(0, 0);
        Location location2 = new Location(1, 1);
        Location location3 = new Location(0, 1);

        Rider rider = new Rider(1, "person1", location1, null);
        Vehicle vehicle = new Car(CarType.SEDAN, 25, 10,
                "honda-car", VehicleType.CAR, 2, "ka-05-blablabla", location3);
        Driver driver = new Driver(1, "driver1", vehicle, DriverStatus.ACTIVELY_LOOKING);

        TripService tripService = new TripService();
        DriverService driverService = new DriverService();
        ProximityService proximityService = new ProximityService(driverService);

        RiderService riderService = new RiderService(tripService, proximityService);
        riderService.registerRider(rider);

        driverService.registerDriver(driver);

        Ride ride = riderService.requestRide(rider, location1, location2);
        driver.endRide(ride);

    }

}