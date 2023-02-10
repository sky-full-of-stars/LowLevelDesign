package com.example.lld.carRentalSystem.model;

public class CashPayment extends Payment {
    @Override
    void payAmount(Double amount) {
        System.out.printf("Received cash payment of {} %n", amount);
    }
}
