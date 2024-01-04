import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double saberPrice = Double.parseDouble(scan.nextLine());
        double robePrice = Double.parseDouble(scan.nextLine());
        double beltPrice = Double.parseDouble(scan.nextLine());

        double totalPriceSabers = Math.ceil(students + students * 0.1) * saberPrice;
        double totalPriceRobes = robePrice * students;
        double totalPriceBelts = (students - students / 6) * beltPrice;

        double totalPrice = totalPriceSabers + totalPriceRobes + totalPriceBelts;

        if (totalPrice <= budget) System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        else System.out.printf("George Lucas will need %.2flv more.", totalPrice - budget);
    }
}