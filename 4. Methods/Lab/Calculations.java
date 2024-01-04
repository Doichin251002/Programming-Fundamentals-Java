import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        switch (command) {
            case "add":
                addNumbers(firstNum, secondNum);
                break;
            case "subtract" :
                subtractNumbers(firstNum, secondNum);
                break;
            case "multiply":
                multiplyNumbers(firstNum, secondNum);
                break;
            case "divine":
                divineNumbers(firstNum, secondNum);
                break;
        }
    }

    public static void addNumbers(int number1, int number2) {
        int result = number1 + number2;
        System.out.println(result);
    }
    public static void subtractNumbers(int number1, int number2) {
        int result = number1 - number2;
        System.out.println(result);
    }
    public static void multiplyNumbers(int number1, int number2) {
        int result = number1 * number2;
        System.out.println(result);
    }
    public static void divineNumbers(int number1, int number2) {
        int result = number1 / number2;
        System.out.println(result);
    }
}
