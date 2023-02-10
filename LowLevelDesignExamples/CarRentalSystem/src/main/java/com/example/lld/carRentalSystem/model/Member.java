package com.example.lld.carRentalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class Member extends Person{
    private String licenseNumber;
    private Date licenseValidTill;

    void getsomethingdone(int x)
    {

    }
}
