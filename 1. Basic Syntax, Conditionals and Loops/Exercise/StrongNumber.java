import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        int startNumber = num;
        int lastDigit = 0;
        int sumFact = 0;

        while (num > 0) {
            lastDigit = num % 10;
            int fact = 1;
            for (int i = 1; i <= lastDigit; i++) {
                fact *= i;
            }
            sumFact += fact;
            num /= 10;
        }

        if (sumFact == startNumber) System.out.println("yes");
        else System.out.println("no");
    }
}