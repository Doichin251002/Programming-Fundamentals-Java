import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startYield = Integer.parseInt(scan.nextLine());

        int totalAmountSpices = 0;
        int remainingAmountSpices = 0;
        int days = 0;
        int workers = 26;

        while (startYield >= 100) {
            days++;
            remainingAmountSpices = startYield - workers;
            totalAmountSpices += remainingAmountSpices;
            startYield -= 10;
        }
        System.out.println(days);
        if (totalAmountSpices >= 26) {
            totalAmountSpices -= 26;
        }
        System.out.println(totalAmountSpices);
    }
}
