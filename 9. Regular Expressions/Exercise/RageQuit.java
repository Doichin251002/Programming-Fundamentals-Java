import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine().toUpperCase();

        Pattern pattern = Pattern.compile("(?<string>\\D+)(?<count>\\d+)");
        Matcher matcher = pattern.matcher(inputLine);

        StringBuilder repeatingString = new StringBuilder();
        List<Character> uniqueSymbolsList = new ArrayList<>();
        while (matcher.find()) {
            String currentString = matcher.group("string");
            int count = Integer.parseInt(matcher.group("count"));

            for (char symbol : currentString.toCharArray()) {
                if (!uniqueSymbolsList.contains(symbol)) {
                    uniqueSymbolsList.add(symbol);
                }
            }

            repeatingString.append(currentString.repeat(count));
        }

        System.out.println("Unique symbols used: " + uniqueSymbolsList.size());
        System.out.println(repeatingString);
    }
}
