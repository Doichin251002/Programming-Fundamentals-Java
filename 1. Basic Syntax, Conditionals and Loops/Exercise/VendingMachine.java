import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        double totalMoney = 0;
        double money;

        while (!command.equals("Start")) {
            money = Double.parseDouble(command);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                totalMoney += money;
            }
            else System.out.printf("Cannot accept %.2f%n", money);
            command = scan.nextLine();
        }

        String product;
        command = scan.nextLine();
        while (!command.equals("End")) {
            product = command;
            switch (product) {
                case "Nuts":
                    if (totalMoney >= 2) {
                        totalMoney -= 2;
                        System.out.printf("Purchased %s%n", product);
                    }
                    else System.out.println("Sorry, not enough money");
                    break;
                case "Water":
                    if (totalMoney >= 0.7) {
                        totalMoney -= 0.7;
                        System.out.printf("Purchased %s%n", product);
                    }
                    else System.out.println("Sorry, not enough money");
                    break;
                case "Crisps":
                    if (totalMoney >= 1.5) {
                        totalMoney -= 1.5;
                        System.out.printf("Purchased %s%n", product);
                    }
                    else System.out.println("Sorry, not enough money");
                    break;
                case "Soda":
                    if (totalMoney >= 0.8) {
                        totalMoney -= 0.8;
                        System.out.printf("Purchased %s%n", product);
                    }
                    else System.out.println("Sorry, not enough money");
                    break;
                case "Coke":
                    if (totalMoney >= 1) {
                        totalMoney -= 1;
                        System.out.printf("Purchased %s%n", product);
                    }
                    else System.out.println("Sorry, not enough money");
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            command = scan.nextLine();
        }
        System.out.printf("Change: %.2f", totalMoney);
    }
}