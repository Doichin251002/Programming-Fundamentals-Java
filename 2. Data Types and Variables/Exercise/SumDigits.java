import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        int currentDigit = 0;
        int sum = 0;

        while (num > 0) {
            currentDigit = num % 10;
            sum += currentDigit;
            num /= 10;
        }
        System.out.println(sum);
    }
}
