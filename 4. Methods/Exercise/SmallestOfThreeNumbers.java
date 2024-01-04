import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        printSmallest(num1, num2, num3);
    }

    public static void printSmallest(int firstNumber, int secondNumber, int thirdNumber) {
        if (firstNumber < secondNumber && firstNumber < thirdNumber) {
            System.out.println(firstNumber);
        } else if (secondNumber < firstNumber && secondNumber < thirdNumber) {
            System.out.println(secondNumber);
        }
        else {
            System.out.println(thirdNumber);
        }
    }
}