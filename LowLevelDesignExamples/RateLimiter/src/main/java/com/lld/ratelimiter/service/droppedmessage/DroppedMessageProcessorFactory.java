package com.lld.ratelimiter.service.droppedmessage;

import com.lld.ratelimiter.enums.DroppedRequestHandlerType;
import com.lld.ratelimiter.service.droppedmessage.impl.DeadLetterQueueForDroppedRequest;
import com.lld.ratelimiter.service.droppedmessage.impl.LogDroppedRequest;

public class DroppedMessageProcessorFactory {

    public DroppedRequestHandler getDroppedRequestHandlerImplementation(DroppedRequestHandlerType way)
    {
        return switch (way) {
            case LOG -> new LogDroppedRequest();
            case DEAD_LETTER_QUEUE -> new DeadLetterQueueForDroppedRequest();
            default -> new LogDroppedRequest();
        };
    }
}
