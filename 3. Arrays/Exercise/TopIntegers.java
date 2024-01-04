import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] numbersArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0;  i <= numbersArr.length - 1; i++) {
            int currentNumber = numbersArr[i];

            if (i == numbersArr.length - 1) {
                System.out.print(currentNumber + " ");
                break;
            }
            boolean isTop = false;

            for (int j = i + 1; j <= numbersArr.length - 1; j++) {
                if (currentNumber > numbersArr[j]) {
                    isTop = true;
                }
                else {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
