package de.mvitz.java.test.libraries;

import org.junit.*;
import org.junit.contrib.java.lang.system.*;

import static org.junit.Assert.*;

public class SystemPropertiesEnvTest {

    @Rule
    public ClearSystemProperties clearedSystemProperty =
        new ClearSystemProperties("java.runtime.name");

    @Test
    public void clearSystemProperty() {
        assertNull(System.getProperty("java.runtime.name"));
    }


    @Rule
    public ProvideSystemProperty provideSystemProperty =
        new ProvideSystemProperty("os.name", "My OS");

    @Test
    public void provideSystemProperty() {
        assertEquals("My OS", System.getProperty("os.name"));
    }


    @Rule
    public RestoreSystemProperties restoreSystemProperties =
        new RestoreSystemProperties();

    @Test
    public void restoreSystemProperty() {
        System.setProperty("foo", "bar");
        System.setProperty("java.runtime.name", "JavaSPEKTRUM VM");
    }


    @Rule
    public EnvironmentVariables environmentVariables =
        new EnvironmentVariables();

    @Test
    public void environmentVariables() {
        environmentVariables.set("FOO", "bar");

        assertEquals("bar", System.getenv("FOO"));
    }
}
