import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        LinkedHashMap<String, List<String>> usersCourseMap = new LinkedHashMap<>();
        while (!command.equals("end")) {
            String course = command.split(" : ")[0];
            String student = command.split(" : ")[1];

            usersCourseMap.putIfAbsent(course, new ArrayList<>());
            usersCourseMap.get(course).add(student);
            command = scan.nextLine();
        }

        usersCourseMap.forEach((key, value) -> {
            System.out.printf("%s: %s%n", key, value.size());
            value.forEach(user -> System.out.printf("-- %s%n", user));
        });
    }
}
