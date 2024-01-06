import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, String> parkingUserMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String inputLine = scan.nextLine();
            String command = inputLine.split(" ")[0];
            String username = inputLine.split(" ")[1];

            if (command.equals("register")) {
                String licenseNum = inputLine.split(" ")[2];

                if (!parkingUserMap.containsKey(username)) {
                    parkingUserMap.put(username, licenseNum);
                    System.out.printf("%s registered %s successfully", username, licenseNum);
                }
                else {
                    System.out.printf("ERROR: already registered with plate number %s", parkingUserMap.get(username));
                }
            }
            else if (command.equals("unregister")) {
                if (!parkingUserMap.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found", username);
                }
                else {
                    System.out.printf("%s unregistered successfully", username);
                    parkingUserMap.remove(username);
                }
            }
            System.out.println();
        }

        parkingUserMap.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
