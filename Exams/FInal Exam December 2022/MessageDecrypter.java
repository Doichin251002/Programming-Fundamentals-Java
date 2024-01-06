import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Pattern pattern = Pattern.compile("^([$%])(?<tag>[A-Z][a-z]{2,})\\1: (?<message>(\\[\\d+\\]\\|){3})$");
        Matcher matcher;

        for (int i = 0; i < n; i++) {
            String inputLine = scan.nextLine();
            matcher = pattern.matcher(inputLine);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                String [] messageValues = matcher.group("message").split("\\W+", -1);

                StringBuilder decryptedMessage = new StringBuilder();
                for (String message : messageValues) {
                    if (!message.equals("")) {
                        int value = Integer.parseInt(message);
                        decryptedMessage.append((char)value);
                    }
                }
                System.out.printf("%s: %s%n", tag, decryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
