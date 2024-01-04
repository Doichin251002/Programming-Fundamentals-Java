import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        boolean isPalindrome;
        while (!command.equals("END")) {
            isPalindrome = isPalindromeNumber(command);
            if (isPalindrome) {
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
            command = scan.nextLine();
        }
    }

    public static boolean isPalindromeNumber(String number) {
        char [] currentNumber = number.toCharArray();
        boolean isPalindromeNumber = false;

        for (int i = 0; i < number.length() / 2; i++) {
            if (currentNumber[i] == currentNumber[number.length() - 1 - i]) {
                isPalindromeNumber = true;
            }
            else {
                isPalindromeNumber = false;
                break;
            }
        }
        return isPalindromeNumber;
    }
}
