package com.lld.ratelimiter.service.droppedmessage.impl;

import com.lld.ratelimiter.service.droppedmessage.DroppedRequestHandler;
import com.lld.ratelimiter.util.DateTimeUtil;

import java.time.Instant;
import java.util.Date;
import java.util.function.Function;

public class LogDroppedRequest implements DroppedRequestHandler {

    @Override
    public void handle(Object input, Function function) {
        System.out.printf("Dropped %s from function id %s as it was out of window at %s .%n",
                            input, function.hashCode(), DateTimeUtil.getCurrentTime());
    }
}
