package ch.zhaw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonteCarloTest {

    @Test
    void calcPiErr2() {
        double err = 1E-2;
        double pi = new MonteCarlo().calcPi(1000000);
        assertEquals(Math.PI, pi, err);
    }

    // @Test
    void calcPiErr3() {
        double err = 1E-3;
        double pi = new MonteCarlo().calcPi(100000000);
        assertEquals(Math.PI, pi, err);
    }

    // @Test
    void calcPiErr4() {
        double err = 1E-4;
        double pi = new MonteCarlo().calcPi(10000000000L);
        assertEquals(Math.PI, pi, err);
    }
}