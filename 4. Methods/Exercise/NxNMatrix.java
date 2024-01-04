import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int baseNumber = Integer.parseInt(scan.nextLine());

        printMatrix(baseNumber);
    }
    public static void printMatrix(int number) {
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
