import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Pattern pattern = Pattern.compile(">>(?<name>\\w+)<<(?<price>\\d+\\.?\\d*)\\!(?<quantity>\\d+)");

        List<String> listFurniture = new ArrayList<>();
        double totalPrice = 0;
        while (!command.equals("Purchase")) {
            String furniture = command;

            Matcher matcher = pattern.matcher(furniture);

            if (matcher.find()) {
                listFurniture.add(matcher.group("name"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += price * quantity;
            }
            command = scan.nextLine();
        }

            System.out.println("Bought furniture:");
            listFurniture.forEach(System.out::println);
            System.out.printf("Total money spend: %.2f", totalPrice);
    }
}