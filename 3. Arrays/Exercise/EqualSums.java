import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] numbersArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isEqual = false;
        for (int currentIndex = 0; currentIndex <= numbersArr.length - 1; currentIndex++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int leftIndex = 0; leftIndex < currentIndex; leftIndex++) {
                leftSum += numbersArr[leftIndex];
            }

            for (int rightIndex = currentIndex + 1; rightIndex <= numbersArr.length - 1; rightIndex++) {
                rightSum += numbersArr[rightIndex];
            }

            if (leftSum == rightSum) {
                isEqual = true;
                System.out.println(currentIndex);
                break;
            }
        }

        if (!isEqual) {
            System.out.println("no");
        }
    }
}
