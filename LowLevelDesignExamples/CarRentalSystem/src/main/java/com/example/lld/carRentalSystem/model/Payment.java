package com.example.lld.carRentalSystem.model;

import com.example.lld.carRentalSystem.enums.PaymentStatus;

public abstract class Payment {
    PaymentStatus status;
    abstract void payAmount(Double amount);
}
