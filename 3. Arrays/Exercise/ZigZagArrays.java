import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());

        String [] firstArr = new String[rows];
        String [] secondArr = new String[rows];

        for (int i = 1; i <= rows; i++) {
            String [] numbers = scan.nextLine().split(" ");
            String firstNumber = numbers[0];
            String secondNumber = numbers[1];

            if (i % 2 == 0) {
                secondArr[i - 1] = firstNumber;
                firstArr[i - 1] = secondNumber;
            }
            else {
                firstArr[i - 1] = firstNumber;
                secondArr[i - 1] = secondNumber;
            }
        }
        System.out.println(String.join(" ", firstArr));
        System.out.println(String.join(" ", secondArr));
    }
}
