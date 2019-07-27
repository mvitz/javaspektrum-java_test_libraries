package de.mvitz.java.test.libraries;

import org.junit.*;
import org.junit.contrib.java.lang.system.*;

public class DisallowSystemOutErrTest {

    @Rule
    public DisallowWriteToSystemOut systemOut =
        new DisallowWriteToSystemOut();

    @Test(expected = AssertionError.class)
    public void systemOut() {
        System.out.println("Hello, world!");
    }


    @Rule
    public DisallowWriteToSystemErr systemErr =
        new DisallowWriteToSystemErr();

    @Test(expected = AssertionError.class)
    public void systemErr() {
        System.err.println("Hello, world!");
    }
}
