import java.util.Scanner;

public class TriangleNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        int row = 1;

        while (row <= num) {
            for (int i = 1; i <= row; i++) {
                System.out.print(row + " ");
            }
            System.out.println();
            row++;
        }
    }
}