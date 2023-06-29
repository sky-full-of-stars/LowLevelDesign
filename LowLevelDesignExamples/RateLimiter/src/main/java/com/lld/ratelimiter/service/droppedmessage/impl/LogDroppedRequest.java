package com.lld.ratelimiter;

import java.time.Instant;
import java.util.function.Function;

public class LogDroppedRequest implements DroppedRequestHandler{

    @Override
    public void handle(Object input, Function function) {
        System.out.printf("Dropped %s from function id %s as it was out of window at %s .%n",
                            input, function.hashCode(), Instant.now());
    }
}
