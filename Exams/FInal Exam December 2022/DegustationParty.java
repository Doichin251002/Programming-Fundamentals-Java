import java.util.*;

public class DegustationParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        Map<String, List<String>> guestLikedMeals = new LinkedHashMap<>();
        int countDislikedMeals = 0;
        while (!command.equals("Stop")) {
            String[] tokens = command.split("-");
            String reaction = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];
            switch (reaction) {
                case "Like":
                    guestLikedMeals.putIfAbsent(guest, new ArrayList<>());
                    guestLikedMeals.get(guest).add(meal);
                    break;
                case "Dislike":
                    if (!guestLikedMeals.containsKey(guest)) {
                    System.out.printf("%s is not at the party.%n", guest);
                    } else if (!guestLikedMeals.get(guest).contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    } else if (guestLikedMeals.get(guest).contains(meal)) {
                        guestLikedMeals.get(guest).remove(meal);
                        countDislikedMeals++;
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        guestLikedMeals.forEach((key, value) -> {
            System.out.printf("%s: ", key);
            System.out.print(String.join(", ", guestLikedMeals.get(key)));
            System.out.println();
        });
        System.out.println("Unliked meals: " + countDislikedMeals);
    }
}
