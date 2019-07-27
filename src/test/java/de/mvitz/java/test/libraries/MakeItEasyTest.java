package de.mvitz.java.test.libraries;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import org.junit.Test;

import static de.mvitz.java.test.libraries.MakeItEasyTest.AutoBuilder.ps;
import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.natpryce.makeiteasy.Property.newProperty;
import static org.junit.Assert.assertEquals;

public class MakeItEasyTest {

    static abstract class Auto {
        private int anzahlReifen;

        public int getAnzahlReifen() {
            return anzahlReifen;
        }

        public void setAnzahlReifen(int anzahlReifen) {
            this.anzahlReifen = anzahlReifen;
        }

    }

    static class Pkw extends Auto {
        private int ps;

        public int getPs() {
            return ps;
        }

        public void setPs(int ps) {
            this.ps = ps;
        }
    }

    static class AutoBuilder {
        static final Property<Auto,Integer> reifen = newProperty();
        static final Property<Pkw,Integer> ps = newProperty();

        static final Instantiator<Pkw> Pkw = lookup -> {
            Pkw pkw = new Pkw();
            pkw.setAnzahlReifen(lookup.valueOf(reifen, 4));
            pkw.setPs(lookup.valueOf(ps, 50));
            return pkw;
        };
    }

    @Test
    public void makeItEasy() {
        Pkw einPkw = an(AutoBuilder.Pkw, with(4711, ps)).make();
        assertEquals(4, einPkw.getAnzahlReifen());
        assertEquals(4711, einPkw.getPs());
    }
}
