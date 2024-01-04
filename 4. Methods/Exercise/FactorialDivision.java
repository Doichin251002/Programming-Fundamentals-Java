import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());

        long factNumber1 = calculateFactorial(number1);
        long factNumber2 = calculateFactorial(number2);

        double result = factNumber1 * 1.0 / factNumber2;
        System.out.printf("%.2f", result);
    }

    public static long calculateFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
