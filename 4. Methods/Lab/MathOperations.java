import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        char symbolInput = scan.nextLine().charAt(0);
        int secondNumber = Integer.parseInt(scan.nextLine());

        System.out.println(calculate(symbolInput, firstNumber, secondNumber));
    }
    public static int calculate(char operation, int number1, int number2) {
        int result = 0;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
        }
        return result;
    }
}
