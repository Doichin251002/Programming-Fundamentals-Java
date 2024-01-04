import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int times = Integer.parseInt(scan.nextLine());

        do {
            System.out.printf("%d X %d = %d%n", num, times, num * times);
            times++;
        }
        while (times <= 10);
    }
}