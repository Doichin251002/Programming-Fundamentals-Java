import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int endNum = Integer.parseInt(scan.nextLine());

        boolean dividedBy8;
        boolean containedOddDigit;

        for (int currentNumber = 1; currentNumber <= endNum; currentNumber++) {
            dividedBy8 = isSumDivided8(currentNumber);
            containedOddDigit = isOddDigit(currentNumber);

            if (dividedBy8 && containedOddDigit) {
                System.out.println(currentNumber);
            }
        }
    }

    public static boolean isSumDivided8(int number) {
        int sumDigits = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            sumDigits += lastDigit;
            number /= 10;
        }
        return sumDigits % 8 == 0;
    }

    public static boolean isOddDigit(int number) {
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
