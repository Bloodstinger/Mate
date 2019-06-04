package lecture.one.twoOfFour;

public class TwoOfFourApp {
    public static void main(String[] args) {

        System.out.println(booleanExpression(Boolean.parseBoolean(args[0]), Boolean.parseBoolean(args[1]),
                Boolean.parseBoolean(args[2]), Boolean.parseBoolean(args[3])));
    }

    private static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return ((a ^ b) & (c ^ d) | ((a ^ c) & (b ^ d)));
    }
}
