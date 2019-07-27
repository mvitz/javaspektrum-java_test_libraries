package de.mvitz.java.test.libraries;

import org.awaitility.core.ConditionTimeoutException;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.is;

public class AwaitilityTest {

    AtomicBoolean bool = new AtomicBoolean(false);

    void methodWithAsyncSideeffect(int timeout) {
        CompletableFuture.runAsync(() -> {
            try {
                SECONDS.sleep(timeout);
            } catch (InterruptedException e) {}
            bool.set(true);
        });
    }

    @Test
    public void awaitilitySuccess() {
        methodWithAsyncSideeffect(3);
        await().atMost(4, SECONDS).untilAtomic(bool, is(true));
    }

    @Test(expected = ConditionTimeoutException.class)
    public void awaitilityFailure() {
        methodWithAsyncSideeffect(5);
        await().atMost(4, SECONDS).untilAtomic(bool, is(true));
    }
}
