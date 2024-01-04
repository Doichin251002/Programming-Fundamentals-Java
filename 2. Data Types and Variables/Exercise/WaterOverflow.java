import java.util.Scanner;

public class WaterOverflow {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int capacity = 255;
        int currentLiters = 0;
        boolean isOverflowed = false;

        for (int i = 0; i < n; i++) {
            int newLiters = Integer.parseInt(scan.nextLine());
            currentLiters += newLiters;
            if (currentLiters > capacity) {
                System.out.println("Insufficient capacity!");
                currentLiters -= newLiters;
            }
        }
        System.out.println(currentLiters);
    }
}
