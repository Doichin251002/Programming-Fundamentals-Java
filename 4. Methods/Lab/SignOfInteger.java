import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        examinationNumber(n);
    }

    public static void examinationNumber(int number) {
        if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        }
        else if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        }
        else {
            System.out.printf("The number %d is zero.", number);
        }
    }
}