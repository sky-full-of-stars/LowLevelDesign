package com.lld.uber.exception;

public class RideNotFoundException extends RuntimeException {
    public RideNotFoundException() {
        super("Sorry, Could not find ride!");
    }
}
