package com.example.lld.carRentalSystem.service;

import com.example.lld.carRentalSystem.database.RentalSystemInventory;
import com.example.lld.carRentalSystem.enums.CarType;
import com.example.lld.carRentalSystem.model.Location;
import com.example.lld.carRentalSystem.model.Store;
import com.example.lld.carRentalSystem.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchService {
    RentalSystemInventory rentalSystemInventory;

    public List<Vehicle> findAllVehiclesByLocation(Location location) {
        return this.rentalSystemInventory.getStores().stream()
                .filter(x -> x.getLocation().equals(location))
                .findFirst().map((value) -> value.getInventory().getVehicles()).orElse(null);
    }

}
