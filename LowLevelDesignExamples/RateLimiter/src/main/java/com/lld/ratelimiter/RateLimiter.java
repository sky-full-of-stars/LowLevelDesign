package com.lld.ratelimiter;

import com.lld.ratelimiter.enums.DroppedRequestHandlerType;
import com.lld.ratelimiter.exceptions.RateLimitExceededException;
import com.lld.ratelimiter.service.droppedmessage.DroppedMessageProcessorFactory;
import com.lld.ratelimiter.service.droppedmessage.DroppedRequestHandler;
import com.lld.ratelimiter.util.DateTimeUtil;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class RateLimiter<I, O> {
    private final int allowedRate;
    private final long windowInMillis;

    private final ConcurrentMap<Function<I, O> , MutablePair<Integer, Long>> callCountWithLastCallTimeMap;

    private final Object lock = new Object();
    private DroppedRequestHandlerType droppedRequestHandlerWay = DroppedRequestHandlerType.LOG;
    DroppedRequestHandler droppedRequestHandler = new DroppedMessageProcessorFactory().
                                                getDroppedRequestHandlerImplementation(droppedRequestHandlerWay);

    public RateLimiter(int allowedRate, long windowInSeconds) {
        this.allowedRate = allowedRate;
        this.windowInMillis = windowInSeconds * 1000;
        this.callCountWithLastCallTimeMap = new ConcurrentHashMap<>();
    }

    /*
        use this constructor if you want to specify what happens to rate limited requests.
     */
    public RateLimiter(int allowedRate, long windowInSeconds, DroppedRequestHandlerType droppedRequestHandlerWay) {
        this.allowedRate = allowedRate;
        this.windowInMillis = windowInSeconds * 1000;
        this.callCountWithLastCallTimeMap = new ConcurrentHashMap<>();
        this.droppedRequestHandlerWay = droppedRequestHandlerWay;
        droppedRequestHandler = new DroppedMessageProcessorFactory().
                getDroppedRequestHandlerImplementation(droppedRequestHandlerWay);
    }


    public Function<I, O> wrap(Function<I, O> func)
    {
        return input -> {
            if (canProceed(func)) {
                return func.apply(input);
            } else {
                droppedRequestHandler.handle(input, func);
                throw new RateLimitExceededException("rate limit exceeded");
            }
        };
    }

    private boolean isCallInNewTimeWindow(long currentTime, long lastCallTime) {
        return (currentTime - lastCallTime >= windowInMillis);
    }

    private boolean isCallWithinAllowedRate(int count){
        return (count < allowedRate);
    }

    private boolean canProceed(Function<I, O> func) {
        synchronized (lock) {
            MutablePair<Integer, Long> callCountAndLastCallTime = callCountWithLastCallTimeMap.get(func);

            long currentTime = DateTimeUtil.getCurrentTimeInMilliSeconds();
            if (Objects.isNull(callCountAndLastCallTime)) {
                MutablePair<Integer, Long> firstCall = new MutablePair<>(1,currentTime);
                callCountWithLastCallTimeMap.put(func, firstCall);
                return true;
            }
            else {
                int callCountInCurWindow = callCountAndLastCallTime.getLeft();
                long lastCallMadeTime = callCountAndLastCallTime.getRight();

                if(isCallInNewTimeWindow(currentTime,lastCallMadeTime)) {
                    callCountAndLastCallTime.setLeft(1);
                    callCountAndLastCallTime.setRight(currentTime);
                    return true;
                }

                if (isCallWithinAllowedRate(callCountInCurWindow)) {
                    callCountAndLastCallTime.setLeft(callCountInCurWindow+1);
                    return true;
                }
            }

            return false;
        }
    }
}
