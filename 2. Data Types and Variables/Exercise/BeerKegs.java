import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countKegs = Integer.parseInt(scan.nextLine());

        double volume = 0;
        double pi = Math.PI;
        double maxVolumeKeg = Double.MIN_VALUE;
        String biggestKeg = "";

        for (int i = 0; i < countKegs; i++) {
            String modelKeg = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());

            volume = pi * Math.pow(radius, 2) * height;

            if (volume > maxVolumeKeg) {
                maxVolumeKeg = volume;
                biggestKeg = modelKeg;
            }
        }
        System.out.println(biggestKeg);
    }
}
