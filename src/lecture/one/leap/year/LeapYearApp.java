package lecture.one.leap.year;

public class LeapYearApp {
    public static void main(String[] args) {
        System.out.println(leapYear(Integer.parseInt(args[0])));
    }

    private static int leapYear(int year) {
        int oneHundred = year / 100;
        int fourHundred = year / 400;
        int leapYear = year / 4;
        return leapYear - oneHundred + fourHundred;
    }
}