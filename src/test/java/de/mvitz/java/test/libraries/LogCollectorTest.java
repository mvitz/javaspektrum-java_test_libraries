package de.mvitz.java.test.libraries;

import dk.bitcraft.lc.JUnit4LogCollector;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class LogCollectorTest {

    Logger logger = LoggerFactory.getLogger(LogCollectorTest.class);

    @Rule
    public JUnit4LogCollector collector = new JUnit4LogCollector(logger);

    @Test
    public void logCollector() {
        logger.info("Hello, world!");

        assertThat(collector.getLogs())
            .containsExactly("Hello, world!");
    }
}
