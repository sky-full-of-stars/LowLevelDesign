package com.lld.ratelimiter;
import com.lld.ratelimiter.exceptions.RateLimitExceededException;
import com.lld.ratelimiter.util.DateTimeUtil;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class RateLimiterTest {

    public static void main(String[] args){
        testAllowedRateInGivenWindow();
        testMoreThanAllowedRateInGivenWindow();
        testAllowedRateInDifferentWindows();
    }

    @Test
    private static void testAllowedRateInGivenWindow() {
        RateLimiter<Integer, Integer> limiter = new RateLimiter<>(10, 1);
        Function<Integer, Integer> square = (x) -> x * x;
        Function<Integer, Integer> rateLimitedSquare = limiter.wrap(square);
        //1 seconds, 10 calls should pass
        for (int i = 0; i < 10; i++) {
            System.out.println("Current time is: " + DateTimeUtil.getCurrentTime());
            try {
                System.out.println("Function output is: "+ rateLimitedSquare.apply(i));
            }
            catch (RateLimitExceededException e) {
                System.out.println(e);
            }
        }
    }

    @Test
    private static void testMoreThanAllowedRateInGivenWindow() {
        RateLimiter<Integer, Integer> limiter = new RateLimiter<>(10, 1);
        Function<Integer, Integer> square = (x) -> x * x;
        Function<Integer, Integer> rateLimitedSquare = limiter.wrap(square);

        //1 seconds, 12 calls should fail 2 calls
        for (int i = 0; i < 12; i++) {
            System.out.println("Current time is: " + DateTimeUtil.getCurrentTime());
            try {
                System.out.println("Function output is: "+ rateLimitedSquare.apply(i));
            }
            catch (RateLimitExceededException e) {
                System.out.println(e);
            }
        }
    }

    @Test
    private static void testAllowedRateInDifferentWindows() {
        RateLimiter<Integer, Integer> limiter = new RateLimiter<>(1, 1);
        Function<Integer, Integer> cube = (x) -> x * x * x;
        Function<Integer, Integer> rateLimitedCube = limiter.wrap(cube);
        //we wait 1sec to make different requests
        //every request will go through
        for (int i = 0; i < 5; i++) {
            System.out.println("Current time is: " + DateTimeUtil.getCurrentTime());
            try {
                System.out.println("Function output is: "+ rateLimitedCube.apply(i));
                Thread.sleep(1000);
            }
            catch (RateLimitExceededException e) {
                System.out.println(e);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }


}
