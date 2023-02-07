package com.lld.parkinglot.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public enum Color {

    RED("Red"), BLACK("Black"), WHITE("White"), BLUE("Blue"), GREY("Grey");

    @Getter
    String colour;

    Color(String colour) {
        this.colour = colour;
    }

    public static Color getColor(String name) {
        Optional<Color> first = Arrays.stream(values()).filter(v -> v.getColour().equals(name)).findFirst();
        return first.orElse(null);
    }
}
