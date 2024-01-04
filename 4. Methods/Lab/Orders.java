import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());

        double price = 0;
        switch (product) {
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
        }

        double cost = calculateOrder(price, count);
        System.out.printf("%.2f", cost);
    }
    public static double calculateOrder(double priceProduct, int countProduct) {
        double totalPrice = priceProduct * countProduct;
        return totalPrice;
    }
}
