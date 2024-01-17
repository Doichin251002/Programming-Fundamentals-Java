import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String foodInfo = scan.nextLine();

        Pattern pattern = Pattern.compile("([#|\\|])(?<food>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<cal>[0-9]+)\\1");
        Matcher matcher = pattern.matcher(foodInfo);

        StringBuilder sb = new StringBuilder();
        int totalKCal = 0;
        while (matcher.find()) {
            String nameFood = matcher.group("food");
            String dateExpiration = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("cal"));

            totalKCal += calories;
            sb.append(String.format("Item: %s, Best before: %s, Nutrition: %d%n", nameFood, dateExpiration, calories));
        }
        int days = totalKCal / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        System.out.println(sb);
    }
}
