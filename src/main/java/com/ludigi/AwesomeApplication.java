package com.ludigi;

import java.time.Clock;
import java.time.LocalDateTime;

public class AwesomeApplication {
    private final static String APPLICATION_VERSION = "1.0.0";
    static Clock clock = Clock.systemDefaultZone();

    public static void main(String[] args) {
        System.out.printf("Awesome application (ver. %s)\n", APPLICATION_VERSION);
        LocalDateTime now = LocalDateTime.now(clock);
        System.out.println("started at: " + now);
    }
}
