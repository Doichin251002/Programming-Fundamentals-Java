import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        LinkedHashMap<String, Short> mapUsersPoints = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> countLanguagesMap = new LinkedHashMap<>();
        while (!command.equals("exam finished")) {
            String username = command.split("-")[0];
            String language = command.split("-")[1];

            if (language.equals("banned")) {
                mapUsersPoints.remove(username);
            }
            else {
                short points = Short.parseShort(command.split("-")[2]);

                mapUsersPoints.putIfAbsent(username, (short)0);
                if (points > mapUsersPoints.get(username)) {
                    mapUsersPoints.put(username, points);
                }

                countLanguagesMap.putIfAbsent(language, 0);
                countLanguagesMap.put(language, countLanguagesMap.get(language) + 1);
            }
            command = scan.nextLine();
        }

        System.out.println("Results:");
        mapUsersPoints.forEach((key, value) -> System.out.println(key + " | " + value));
        System.out.println("Submissions:");
        countLanguagesMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
