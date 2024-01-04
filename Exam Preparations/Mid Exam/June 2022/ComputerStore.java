import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        double priceNotTaxes = 0;
        while (!command.equals("special") && !command.equals("regular")) {
            double price = Double.parseDouble(command);
            if (price > 0) priceNotTaxes += price;
            else System.out.println("Invalid price!");
            command = scan.nextLine();
        }

        if (priceNotTaxes != 0) {
            double taxes = priceNotTaxes * 0.2;
            double totalPrice = priceNotTaxes + taxes;
            if (command.equals("special")) totalPrice -= totalPrice * 0.1;

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceNotTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.printf("-----------%n" +
                    "Total price: %.2f$", totalPrice);
        }
        else System.out.println("Invalid order!");
    }
}