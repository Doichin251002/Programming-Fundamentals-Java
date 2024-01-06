import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);

        String command = scan.nextLine();
        double income = 0;
        while (!command.equals("end of shift")) {
            String currentOrder = command;

            Matcher matcher = pattern.matcher(currentOrder);
            if (matcher.find()) {
                String customer = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double totalPrice = price * count;
                income += totalPrice;

                System.out.printf("%s: %s - %.2f%n", customer, product, totalPrice);
            }
            command = scan.nextLine();
        }

        System.out.printf("Total income: %.2f", income);
    }
}
