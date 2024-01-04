import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersArr1 = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbersArr2 = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isDifferent = false;
        int differentIndex = 0;
        int sumEqualsNumbers = 0;
        for (int i = 0; i < numbersArr1.length; i++) {
            sumEqualsNumbers += numbersArr1[i];
            if (numbersArr1[i] != numbersArr2[i]) {
                isDifferent = true;
                differentIndex = i;
                break;
            }
        }
        if (!isDifferent) {
            System.out.printf("Arrays are identical. Sum: %d", sumEqualsNumbers);
        }
        else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", differentIndex);
        }
    }
}
