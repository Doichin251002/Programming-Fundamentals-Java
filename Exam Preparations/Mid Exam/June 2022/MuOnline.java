import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dungeonRooms = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;

        for (int i = 0; i < dungeonRooms.length; i++) {
            String currentRoom = dungeonRooms[i];

            String command = currentRoom.split("\\s+")[0];
            int number = Integer.parseInt(currentRoom.split("\\s+")[1]);

            switch (command) {
                case "potion":
                    int previouslyHealth = health;
                    health += number;

                    if (health > 100) {
                        health = 100;

                        number = health - previouslyHealth;

                    }
                    System.out.printf("You healed for %d hp.\n", number);
                    System.out.printf("Current health: %d hp.", health);
                    break;
                case "chest":
                    bitcoins += number;

                    System.out.printf("You found %d bitcoins.", number);
                    break;
                default:
                    health -= number;

                    if (health > 0) {
                        System.out.printf("You slayed %s.", command);
                    } else {
                        System.out.printf("You died! Killed by %s.\n", command);
                        System.out.printf("Best room: %d", ++i);
                        return;
                    }
            }

            System.out.println();
        }

        System.out.printf("You've made it!\n" +
                        "Bitcoins: %d\n" +
                        "Health: %d",
                bitcoins, health
        );

    }
}