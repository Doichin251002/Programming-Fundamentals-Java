import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        int sum = addNumbers(num1, num2);
        int result = subtractNumbers(sum, num3);
        System.out.println(result);
    }
    public static int addNumbers(int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        return sum;
    }
    public static int subtractNumbers(int number1, int number2) {
        int result = number1 - number2;
        return result;
    }
}
