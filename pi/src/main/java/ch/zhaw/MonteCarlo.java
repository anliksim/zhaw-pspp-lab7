package ch.zhaw;

import ch.zhaw.random.HighQualityRandom;

import java.util.Random;
import java.util.stream.Stream;

public class MonteCarlo {

    private final Random random = new HighQualityRandom();

    public double calcPi(long count) {
        return 4 * calcQuarterPi(count);
    }

    private double calcQuarterPi(long count) {

        long hits = Stream.generate(this::xyArray)
                //.parallel() // enabled parallel execution
                .mapToInt(MonteCarlo::inScope)
                .limit(count)
                .sum();

        return (double) hits / count;
    }

    private double[] xyArray() {
        return new double[]{random.nextDouble(), random.nextDouble()};
    }

    private static int inScope(double[] xy) {
        return xy[0] * xy[0] + xy[1] * xy[1] < 1 ? 1 : 0;
    }
}
