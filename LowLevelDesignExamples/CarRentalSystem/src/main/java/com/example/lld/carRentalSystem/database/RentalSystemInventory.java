package com.example.lld.carRentalSystem.database;

import com.example.lld.carRentalSystem.model.Member;
import com.example.lld.carRentalSystem.model.Store;
import com.example.lld.carRentalSystem.model.Worker;
import lombok.Data;

import java.util.List;

@Data
public class RentalSystemInventory {
    private List<Member> users;
    private List<Store> stores;
    private List<Worker> workers;
}
