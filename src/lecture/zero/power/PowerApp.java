package lecture.zero.power;

public class PowerApp {
    public static void main(String[] args) {
        System.out.println(numberToPower(5, 4));
    }

    private static int numberToPower(int number, int power) {
        int result = 1;
        if (power >= 0) {
            for (int i = 0; i < power; i++) {
                result = result * number;
            }
        } else {
            for (int i = 0; i < power; i++) {
                result = 1 / (result * number);
            }
        }
        return result;
    }
}