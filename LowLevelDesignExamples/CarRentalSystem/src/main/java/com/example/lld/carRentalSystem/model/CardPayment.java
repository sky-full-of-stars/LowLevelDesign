package com.example.lld.carRentalSystem.model;

public class CardPayment extends Payment {
    @Override
    void payAmount(Double amount) {
        System.out.printf("Received card payment of {} %n", amount);
    }
}
