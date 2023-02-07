package com.lld.parkinglot.model;

import lombok.Getter;

import java.util.List;

public class Command {
    @Getter
    private String name;
    @Getter
    private List<String> params;

    public Command(String name, List<String> params) {
        this.name = name;
        this.params = params;
    }
}
