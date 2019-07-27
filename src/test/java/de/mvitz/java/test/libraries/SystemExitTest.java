package de.mvitz.java.test.libraries;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class SystemExitTest {

    @Rule
    public ExpectedSystemExit systemExit =
        ExpectedSystemExit.none();

    @Test
    public void systemExit() {
        systemExit.expectSystemExitWithStatus(4711);

        System.exit(4711);
    }
}
