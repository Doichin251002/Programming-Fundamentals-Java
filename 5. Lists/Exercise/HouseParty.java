import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countGuests = Integer.parseInt(scan.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 0; i < countGuests; i++) {
            String [] inputArray = scan.nextLine().split(" ");
            String currentGuest = inputArray[0];
            String status = inputArray[2];

            if (status.equals("going!")) {
                if (guestList.contains(currentGuest)) {
                    System.out.printf("%s is already in the list!%n", currentGuest);
                } else {
                    guestList.add(currentGuest);
                }
            } else if (status.equals("not")) {
                if (guestList.contains(currentGuest)) {
                    guestList.remove(String.valueOf(currentGuest));
                } else {
                    System.out.printf("%s is not in the list!%n", currentGuest);
                }
            }
        }

        for (String guest: guestList) {
            System.out.println(guest);
        }
    }
}
