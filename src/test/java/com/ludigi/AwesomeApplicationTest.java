package com.ludigi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AwesomeApplicationTest {
    private final PrintStream originalOut = System.out;
    private final OutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void changeDefaultOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void shouldPrintMessageWithAppVersion() {
        AwesomeApplication.main(new String[]{});
        assertTrue(outContent
                .toString()
                .matches("Awesome application \\(ver\\. \\d+\\.\\d+\\.\\d+\\)")
        );
    }

    @AfterEach
    void restoreDefaultOutputStream() {
        System.setOut(originalOut);
    }
}