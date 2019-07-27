package de.mvitz.java.test.libraries;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

public class JavaFakerTest {

    @Test
    public void javaFaker() {
        System.out.println(Faker.instance().artist().name());

        System.out.println(Faker.instance(Locale.ENGLISH).color().name());
        System.out.println(Faker.instance(Locale.GERMAN).color().name());

        System.out.println(Faker.instance().slackEmoji().nature());
    }

    @Test
    public void reproducableData() {
        Random random = new Random(4711);

        Faker faker = Faker.instance(Locale.GERMAN, random);

        // prints "Chuck Norris kann im Kinderkarussell überholen." every time
        System.out.println(faker.chuckNorris().fact());
    }
}
