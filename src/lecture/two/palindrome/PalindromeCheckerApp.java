package lecture.two.palindrome;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        try {
            System.out.println(isPalindrome(args[0]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input should be a string.");
        }
    }

    private static boolean isPalindrome(String text) {
        String reversed = new StringBuilder().append(text).reverse().toString();
        return text.replaceAll("[^A-Za-z1-9]+", "")
                .equals(reversed.replaceAll("[^A-Za-z1-9]+", ""));
    }
}
