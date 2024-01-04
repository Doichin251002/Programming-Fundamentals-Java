import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] numbersArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int searchedSum = Integer.parseInt(scan.nextLine());

        for (int curIndex = 0; curIndex <= numbersArr.length - 1; curIndex++) {
            int currentNum = numbersArr[curIndex];
            for (int nextIndex = curIndex + 1; nextIndex <= numbersArr.length - 1; nextIndex++) {
                int nextNum = numbersArr[nextIndex];

                if (currentNum + nextNum == searchedSum) {
                    System.out.printf("%d %d%n", currentNum, nextNum);
                    break;
                }
            }
        }
    }
}
