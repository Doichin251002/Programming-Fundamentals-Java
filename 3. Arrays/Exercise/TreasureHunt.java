import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] treasureChest = scan.nextLine().split("\\|");
        String command = scan.nextLine();

        while (!command.equals("Yohoho!")) {
            String [] commandParts = command.split(" ");

            if (command.contains("Loot")) {
                for (int i = 1; i < commandParts.length; i++) {
                    boolean alreadyContained = false;
                    for (int j = 0; j < treasureChest.length; j++) {
                        if (commandParts[i].equals(treasureChest[j])) {
                            alreadyContained = true;
                            break;
                        }
                    }
                    if (!alreadyContained) {
                        String newChest = commandParts[i] + " " + String.join(" ", treasureChest);
                        treasureChest = newChest.split(" ");
                    }
                }
            }
            else if (command.contains("Drop")) {
                int position = Integer.parseInt(commandParts[1]);

                if (position >= 0 && position <= treasureChest.length - 1) {
                    String droppedItem = treasureChest[position];
                    for (int i = position; i < treasureChest.length - 1; i++) {
                        treasureChest[i] = treasureChest[i + 1];
                    }
                    treasureChest[treasureChest.length - 1] = droppedItem;
                }
            }
            else if (command.contains("Steal")) {
                int stolenItems = Integer.parseInt(commandParts[1]);
                if (stolenItems >= 0 && stolenItems < treasureChest.length) {
                    for (int i = 0; i < stolenItems; i++) {
                        System.out.print(treasureChest[treasureChest.length - stolenItems + i]);
                        if (i != stolenItems - 1) {
                            System.out.print(", ");
                        }
                    }
                    String [] tempChest = new String[treasureChest.length - stolenItems];
                    for (int i = 0; i < tempChest.length; i++) {
                        tempChest[i] = treasureChest[i];
                    }
                    treasureChest = tempChest;
                }
                else if (stolenItems >= 0) {
                    for (int i = 0; i < treasureChest.length; i++) {
                        System.out.print(treasureChest[i]);
                        if (i != treasureChest.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    treasureChest = new String[0];
                }
                System.out.println();
                break;
            }
            command = scan.nextLine();
        }

        String treasureCount = String.join("", treasureChest);
        int sumLengthItems = 0;

        for (int i = 0; i < treasureCount.length(); i++) {
            sumLengthItems++;
        }
        double avTreasureGain = (sumLengthItems * 1.0) / treasureChest.length;
        if (treasureChest.length > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", avTreasureGain);
        }
        else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
