package com.lld.uber.model;

import com.lld.uber.enums.DriverStatus;
import com.lld.uber.enums.RideStatus;
import com.lld.uber.enums.RideType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Ride {
    private String id;
    private RideType rideType;
    private int fare;
    private Driver driver;
    private List<Rider> riderList;
    private Location source;
    private Location destination;
    private Date dateTime;
    private RideStatus rideStatus;
}
