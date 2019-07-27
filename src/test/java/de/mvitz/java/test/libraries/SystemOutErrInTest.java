package de.mvitz.java.test.libraries;

import org.junit.*;
import org.junit.contrib.java.lang.system.*;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class SystemOutErrInTest {

    @Rule
    public SystemOutRule systemOut = new SystemOutRule().enableLog().mute();

    @Test
    public void systemOut() {
        System.out.println("Hello, world!");

        assertEquals("Hello, world!\n", systemOut.getLog());
    }


    @Rule
    public SystemErrRule systemErr = new SystemErrRule().enableLog().mute();

    @Test
    public void systemErr() {
        System.err.println("Hello, world!");

        assertEquals("Hello, world!\n", systemErr.getLog());
    }


    @Rule
    public TextFromStandardInputStream systemIn = emptyStandardInputStream();

    @Test
    public void systemIn() {
        Scanner sc = new Scanner(System.in);

        systemIn.provideLines("Hello, world!");

        assertEquals("Hello, world!", sc.nextLine());
    }
}
