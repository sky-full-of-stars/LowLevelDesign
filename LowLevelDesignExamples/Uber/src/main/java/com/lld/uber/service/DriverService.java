package com.lld.uber.service;

import com.lld.uber.model.Driver;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DriverService {
    private List<Driver> driverList = new ArrayList<>();

    public void registerDriver(Driver driver) {
        driverList.add(driver);
    }
}
