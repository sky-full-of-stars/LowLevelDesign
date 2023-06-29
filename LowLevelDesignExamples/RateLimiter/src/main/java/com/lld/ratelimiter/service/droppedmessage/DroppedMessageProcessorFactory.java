package com.lld.ratelimiter;

public class DroppedMessageProcessorFactory {

    public DroppedRequestHandler getDroppedRequestHandlerImplementation(String way)
    {
        if(way.equals("LOG"))
        {
            return new LogDroppedRequest();
        }
        return new LogDroppedRequest();
    }
}
