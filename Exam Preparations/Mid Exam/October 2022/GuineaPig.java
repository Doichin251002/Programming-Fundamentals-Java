import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double foodQuantityKg = Double.parseDouble(scan.nextLine());
        double hayQuantityKg = Double.parseDouble(scan.nextLine());
        double coverQuantityKg = Double.parseDouble(scan.nextLine());
        double pigWeightKg = Double.parseDouble(scan.nextLine());

        double foodQuantityGr = foodQuantityKg * 1000;
        double hayQuantityGr = hayQuantityKg * 1000;
        double coverQuantityGr = coverQuantityKg * 1000;
        double pigWeightGr = pigWeightKg * 1000;

        boolean isEnough = true;

        for (int day = 1; day <= 30; day++) {
            foodQuantityGr -= 300;

            if (day % 2 == 0) {
                double currentHay = foodQuantityGr * 0.05;
                hayQuantityGr -= currentHay;
            }

            if (day % 3 == 0) {
                double currentCover = pigWeightGr / 3;
                coverQuantityGr -= currentCover;
            }

            if (foodQuantityGr <= 0 || hayQuantityGr <= 0 || coverQuantityGr <= 0) {
                isEnough = false;
                break;
            }
        }

        if (isEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    foodQuantityGr / 1000, hayQuantityGr / 1000, coverQuantityGr / 1000);
        }
        else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}