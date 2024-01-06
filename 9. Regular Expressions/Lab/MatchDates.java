import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String datesLine = scan.nextLine();

        Pattern regex = Pattern.compile("(?<day>\\d{2})(?<separator>[\\.\\-\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})");
        Matcher matcher = regex.matcher(datesLine);

        String day;
        String month;
        String year;
        while (matcher.find()) {
            day = matcher.group("day");
            month = matcher.group("month");
            year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}
