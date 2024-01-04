import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //
        String[] valuesArr = scan.nextLine().split(" ");
        int[] numbersArr = new int[valuesArr.length];
        for (int i = 0; i < valuesArr.length; i++) {
            numbersArr[i] = Integer.parseInt(valuesArr[i]);
        }
//      equals to
//      int[] numbersArr = Arrays
//                         .stream(scan.nextLine().split(" "))
//                         .mapToInt(Integer::parseInt)
//                         .toArray();

        int sumEvenValues = 0;
        for (int i : numbersArr) {
            if (i % 2 == 0) {
                sumEvenValues += i;
            }
        }
        System.out.println(sumEvenValues);
    }
}
