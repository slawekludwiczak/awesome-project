package com.ludigi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class AwesomeApplicationTest {
    private final PrintStream originalOut = System.out;
    private OutputStream outContent;

    @BeforeEach
    void changeDefaultOutputStream() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void shouldPrintMessageWithAppVersionAndTime() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        AwesomeApplication.clock = clock;
        AwesomeApplication.main(new String[]{});
        String[] output = outContent.toString().split("\n");
        assertTrue(output[0].matches("Awesome application \\(ver\\. \\d+\\.\\d+\\.\\d+\\)"));
        assertTrue(output[1].contains(LocalDateTime.now(clock).toString()));
    }

    @AfterEach
    void restoreDefaultOutputStream() {
        System.setOut(originalOut);
    }
}