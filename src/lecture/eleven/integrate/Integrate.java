package lecture.eleven.integrate;

import java.util.function.DoubleUnaryOperator;

public class Integrate {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int scale = 1_000_000;
        double result = 0;
        double step = (b - a) / scale;
        for (int i = 0; i < scale; i++) {
            result = result + f.applyAsDouble(a + step * (i + 0.5));
        }
        return result * step;
    }
}
