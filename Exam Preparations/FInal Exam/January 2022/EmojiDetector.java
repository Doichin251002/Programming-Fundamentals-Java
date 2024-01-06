import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        Pattern pattern = Pattern.compile("([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);

        int coolThreshold = 1;
        text = text.replaceAll("\\D+", "");
        for (char currentSymbol : text.toCharArray()) {
            if (Character.isDigit(currentSymbol)) {
                coolThreshold *= Integer.parseInt(currentSymbol + "");
            }
        }

        System.out.println("Cool threshold: " + coolThreshold);

        List<String> coolnessEmojis = new ArrayList<>();
        int countEmojis = 0;
        while (matcher.find()) {
            String emoji = matcher.group();
            countEmojis++;

            int coolnessEmoji = 0;
            for (char currentSymbol : text.toCharArray()) {
                coolnessEmoji += currentSymbol;
            }

            if (coolnessEmoji >= coolThreshold) {
                coolnessEmojis.add(emoji);
            }
        }

        System.out.println(countEmojis + " emojis found in the text. The cool ones are:");
        coolnessEmojis.forEach(System.out::println);
    }
}
