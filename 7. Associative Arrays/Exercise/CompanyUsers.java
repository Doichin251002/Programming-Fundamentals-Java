import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        LinkedHashMap<String, List<String>> mapCompanyUsers = new LinkedHashMap<>();
        while (!command.equals("End")) {
            String company = command.split(" -> ")[0];
            String userID = command.split(" -> ")[1];

            mapCompanyUsers.putIfAbsent(company, new ArrayList<>());

            boolean isExist = false;
            for (String users : mapCompanyUsers.get(company)){
                if (users.equals(userID)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                mapCompanyUsers.get(company).add(userID);
            }
            command = scan.nextLine();
        }

        mapCompanyUsers.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(user -> System.out.println("-- " + user));
        });
    }
}
