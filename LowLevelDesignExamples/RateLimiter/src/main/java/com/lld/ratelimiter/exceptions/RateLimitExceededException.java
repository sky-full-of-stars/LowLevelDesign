package com.lld.ratelimiter.exceptions;

public class RateLimitExceededException extends RuntimeException {
    public RateLimitExceededException(String msg) {
        super(msg);
    }
}
