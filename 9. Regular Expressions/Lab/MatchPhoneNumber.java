import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String phoneNumbersLine = scan.nextLine();

        Pattern regex = Pattern.compile("\\+359([- ])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = regex.matcher(phoneNumbersLine);

        List<String> listPhoneNumber = new ArrayList<>();
        while (matcher.find()) {
            listPhoneNumber.add(matcher.group());
        }
        System.out.println(String.join(", ", listPhoneNumber));
    }
}
