package lecture.zero.diamond;

public class DiamondApp {
    public static void main(String[] args) {
        diamond(5);
    }

    private static void diamond(int number) {
        String space = " ";
        String asterisk = " *";
        int spaces = number;
        int columns = 1;
        for (int i = 0; i <= number * 2 - 1; i++) {
            for (int k = 0; k < spaces; k++) {
                System.out.print(space);
            }
            for (int j = 0; j < columns - 1; j++) {
                System.out.print(asterisk);
            }
            System.out.println();
            if (i < number) {
                columns += 1;
                spaces = spaces - 1;
            } else {
                columns -= 1;
                spaces = spaces + 1;
            }
        }
    }
}
