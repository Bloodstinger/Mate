package lecture.one.flipbit;

public class FlipBitApp {
    public static void main(String[] args) {
        try {
            System.out.println(flipBit(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input arguments should be : [value] [bitIndex]");
        }
    }

    private static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1));
    }
}
