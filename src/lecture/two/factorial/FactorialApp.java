package lecture.two.factorial;

import java.math.BigInteger;

public class FactorialApp {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    private static BigInteger factorial(int value) {
        int count = 1;
        for (int i = 1; i <= value; i++) {
            count *= i;
        }
        return BigInteger.valueOf(count);
    }
}
