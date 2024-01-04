import java.util.Scanner;

public class BiscuitFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countBiscuitsPerDayWorker = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());
        int totalCountBiscuitsOtherFactory = Integer.parseInt(scan.nextLine());

        double totalCountBiscuits = 0;
        for (int day = 1; day <= 30; day++) {
            int countBiscuitsPerDay = countBiscuitsPerDayWorker * workers;
            if (day % 3 == 0) {
                countBiscuitsPerDay *= 0.75;
            }
            totalCountBiscuits += countBiscuitsPerDay;
        }
        System.out.printf("You have produced %.0f biscuits for the past month.%n", Math.floor(totalCountBiscuits));

        double difference = Math.abs(totalCountBiscuits - totalCountBiscuitsOtherFactory);
        double percentDifference = difference / totalCountBiscuitsOtherFactory * 100;
        if (totalCountBiscuits > totalCountBiscuitsOtherFactory) {
            System.out.printf("You produce %.2f percent more biscuits.", percentDifference);
        } else if (totalCountBiscuits < totalCountBiscuitsOtherFactory) {
            System.out.printf("You produce %.2f percent less biscuits.", percentDifference);
        }
    }
}