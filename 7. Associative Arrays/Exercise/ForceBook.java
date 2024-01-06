import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        LinkedHashMap<String, List<String>> membersMap = new LinkedHashMap<>();
        while (!command.equals("Lumpawaroo")) {
            if (command.contains(" | ")) {
                String side = command.split(" \\| ")[0];
                String user = command.split(" \\| ")[1];

                if (!membersMap.containsKey(side)) {
                    membersMap.put(side, new ArrayList<>());
                }
                boolean isExistUser = false;
                for (List<String> listUsers : membersMap.values()) {
                    if (listUsers.contains(user)) {
                        isExistUser = true;
                        break;
                    }
                }
                if (!isExistUser) {
                    membersMap.get(side).add(user);
                }
            }
            else if (command.contains(" -> ")) {
                String user = command.split(" -> ")[0];
                String side = command.split(" -> ")[1];

                membersMap.forEach((key, value) -> value.remove(user));

                if (!membersMap.containsKey(side)) {
                    membersMap.put(side, new ArrayList<>());
                }
                membersMap.get(side).add(user);

                System.out.printf("%s joins the %s side!%n", user, side);
            }
            command = scan.nextLine();
        }

        membersMap.entrySet().stream().filter(e -> e.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(user -> System.out.println("! " + user));
                });
    }
}
