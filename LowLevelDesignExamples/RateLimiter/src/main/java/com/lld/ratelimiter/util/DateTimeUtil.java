package com.lld.ratelimiter.util;

import java.time.Instant;
import java.time.LocalTime;

public class DateTimeUtil {

    public static LocalTime getCurrentTime(){
        return java.time.LocalTime.now();
    }

    public static long getCurrentTimeInMilliSeconds() {
        return Instant.now().toEpochMilli();
    }
}
