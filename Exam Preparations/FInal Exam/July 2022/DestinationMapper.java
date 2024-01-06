import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String locationsLine = scan.nextLine();

        Pattern pattern = Pattern.compile("([=\\/])(?<place>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(locationsLine);

        List<String> locationsList = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()) {
            locationsList.add(matcher.group("place"));
            travelPoints += matcher.group("place").length();
        }

        System.out.println("Destinations: " + String.join(", ", locationsList));
        System.out.println("Travel Points: " + travelPoints);
    }
}
