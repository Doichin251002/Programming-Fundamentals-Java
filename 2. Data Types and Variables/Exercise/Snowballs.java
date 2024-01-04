import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countSnowballs = Integer.parseInt(scan.nextLine());

        double biggestSnowballValue = Double.MIN_VALUE;
        double currentSnowballValue;
        int biggestSnow = 0;
        int biggestTime = 0;
        int biggestQuality = 0;

        for (int i = 0; i < countSnowballs; i++) {
            int snow = Integer.parseInt(scan.nextLine());
            int time = Integer.parseInt(scan.nextLine());
            int quality = Integer.parseInt(scan.nextLine());
            currentSnowballValue = Math.pow(snow / time, quality);

            if (currentSnowballValue > biggestSnowballValue) {
                biggestSnowballValue = currentSnowballValue;
                biggestSnow = snow;
                biggestTime = time;
                biggestQuality = quality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", biggestSnow, biggestTime, biggestSnowballValue, biggestQuality);
    }
}
