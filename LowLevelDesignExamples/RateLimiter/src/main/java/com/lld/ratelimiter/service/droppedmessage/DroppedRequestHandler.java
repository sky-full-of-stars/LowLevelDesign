package com.lld.ratelimiter.service.droppedmessage;

import java.util.function.Function;

public interface DroppedRequestHandler<I,O> {
    void handle(I input, Function<I,O> function);
}
