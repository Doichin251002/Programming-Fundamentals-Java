import java.util.Scanner;

public class PrintNumsReverseOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numArr = new int[n];

        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(scan.nextLine());
        }

        for (int i = numArr.length - 1; i >= 0; i--) {
            System.out.print(numArr[i] + " ");
        }
    }
}
