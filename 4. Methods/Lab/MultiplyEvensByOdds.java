import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputNumber = Math.abs(Integer.parseInt(scan.nextLine()));

        int result = multiplyEvensByOdds(inputNumber);
        System.out.println(result);
    }
    public static int multiplyEvensByOdds(int num) {
        int evenSum = sumEvens(num);
        int oddSum = sumOdds(num);

        return evenSum * oddSum;
    }
    public static int sumEvens(int num) {
        String intToString = Integer.toString(num);

        int[] arr = Arrays
                .stream(intToString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
    public static int sumOdds(int num) {
        String intToString = Integer.toString(num);

        int[] arr = Arrays
                .stream(intToString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}
