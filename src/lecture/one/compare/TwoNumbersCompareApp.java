package lecture.one.compare;

public class TwoNumbersCompareApp {
    private static final double ACCURACY = 0.0001;

    public static void main(String[] args) {
        System.out.println(isTrue(0.15, 0.27, 0.42));
    }

    private static boolean isTrue(double a, double b, double c) {
        return Math.abs((a + b) - c) < ACCURACY;
    }
}
