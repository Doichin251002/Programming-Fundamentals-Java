import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        printTriangle(n);
    }

    public static void printTriangle(int number) {
        for (int topRow = 1; topRow <= number; topRow++) {
            printLine(1, topRow);
        }
        for (int bottomRow = number - 1; bottomRow >= 1; bottomRow--) {
            printLine(1, bottomRow);
        }
    }

    public static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }
}