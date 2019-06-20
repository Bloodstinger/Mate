package lecture.eleven.integrate;

import java.util.function.DoubleUnaryOperator;

public class Integrate {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int i;
        int scale = 1000000;
        double result = 0;
        double step;
        step = (b-a)/scale;
        for(i=0; i< scale; i++){
            result = result + f.applyAsDouble(a+ step*(i+0.5));
        }
        result *= step;
        return result;
    }
}
