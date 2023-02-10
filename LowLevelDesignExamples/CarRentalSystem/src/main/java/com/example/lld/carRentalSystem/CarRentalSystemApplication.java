package com.example.lld.carRentalSystem;

import com.example.lld.carRentalSystem.database.RentalSystemInventory;
import com.example.lld.carRentalSystem.enums.CarType;
import com.example.lld.carRentalSystem.model.*;
import com.example.lld.carRentalSystem.service.SearchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CarRentalSystemApplication {

    private static Reservation reservation = new Reservation();

    public static void main(String[] args) {
        SpringApplication.run(CarRentalSystemApplication.class, args);
        RentalSystemInventory inventory = buildRentalSystem();
        SearchService search = new SearchService(inventory);
        Member user = inventory.getUsers().get(0);

        Location location = new Location("Bangalore", "577202");
        List<Vehicle> vehiclesAvailable = search.findAllVehiclesByLocation(location);
        reservation.reserveVehicle(vehiclesAvailable.get(0),user,Date.from(Instant.now()), Date.from(Instant.now()),location, location);

        System.out.println("Reservation id is " + reservation.getId());
    }

    private static RentalSystemInventory buildRentalSystem() {
        RentalSystemInventory inventory = new RentalSystemInventory();
        inventory.setUsers(buildUsers());
        inventory.setStores(buildStores());
        inventory.setWorkers(buildWorkers());
        return inventory;
    }

    private static List<Worker> buildWorkers() {
        List<Worker> workers = new ArrayList<>();
        Worker worker = new Worker();
        workers.add(worker);
        return workers;
    }

    private static List<Store> buildStores() {
        List<Store> stores = new ArrayList<>();
        VehicleInventory inventory = new VehicleInventory(buildVehicles());
        Location location = new Location("Bangalore", "577202");
        Store store = new Store(1, "firstShop", inventory, location, null);
        stores.add(store);
        return stores;
    }

    private static List<Vehicle> buildVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        Car car = new Car();
        car.setCarType(CarType.SEDAN);
        car.setAvailable(true);
        car.setName("Polo");
        car.setRegNum("MY-CAR-8055");
        car.setMilage(20);
        car.setKmsDriven(2000);
        vehicles.add(car);
        return vehicles;
    }

    private static List<Member> buildUsers() {
        List<Member> members = new ArrayList<>();
        Member member = new Member();
        member.setId("1");
        member.setName("Akshay");
        member.setEmail("blabla@blabla.com");
        member.setLicenseNumber("BLA_BLA_BLA");
        member.setLicenseValidTill(new Date(2024,5, 12));
        members.add(member);
        return members;
    }

}
