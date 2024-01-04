import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lostGames = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());

        int countHeadset = lostGames / 2;
        int countMouse = lostGames / 3;
        int countKeyboard = lostGames / 6;
        int countDisplay = lostGames / 12;

        double totalPrice = (headsetPrice * countHeadset) + (mousePrice * countMouse) + (keyboardPrice * countKeyboard) + (displayPrice * countDisplay);
        System.out.printf("Rage expenses: %.2f lv.", totalPrice);
    }
}