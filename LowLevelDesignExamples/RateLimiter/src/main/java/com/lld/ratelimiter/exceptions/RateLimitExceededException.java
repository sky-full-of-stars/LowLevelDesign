package com.lld.ratelimiter.exceptions;

public class RateLimiterException extends RuntimeException {
    public RateLimiterException(String msg) {
        super(msg);
    }
}
