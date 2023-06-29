package com.lld.ratelimiter.service.droppedmessage.impl;

import com.lld.ratelimiter.service.droppedmessage.DroppedRequestHandler;

import java.util.function.Function;

public class DeadLetterQueueForDroppedRequest implements DroppedRequestHandler {
    @Override
    public void handle(Object input, Function function) {
        //logic
    }
}
