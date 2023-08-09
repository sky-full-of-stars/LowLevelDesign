package com.lld.stackoverflow.model;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String name;
    private Date dob;
    private String email;
}
