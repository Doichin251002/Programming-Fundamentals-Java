import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbersArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int evenNumSum = 0;
        int oddNumSum = 0;
        for (int i : numbersArr) {
            if (i % 2 == 0) {
                evenNumSum += i;
            } else {
                oddNumSum += i;
            }
        }
        System.out.println(evenNumSum - oddNumSum);
    }
}
