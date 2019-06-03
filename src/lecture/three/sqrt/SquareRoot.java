package lecture.three.sqrt;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(625));
    }

    private static double sqrt(double number) {
        if (number > 0) {
            Math.sqrt(number);
        } else {
            throw new IllegalArgumentException("Expected non-negative number, got " + number);
        }
        return number;

    }
}
