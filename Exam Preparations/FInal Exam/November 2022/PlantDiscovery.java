import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Integer> plantRarityMap = new HashMap<>();
        Map<String, Double> plantRatingMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            plantRarityMap.put(plant, rarity);
            plantRatingMap.put(plant, 0.0);
        }


        String command = scan.nextLine();
        while (!command.equals("Exhibition")) {
            String [] tokens = command.split("[: -]+");
            String operation = tokens[0];
            String plant = tokens[1];

            if (plantRarityMap.containsKey(plant)) {
                switch (operation) {
                    case "Rate":
                        double rating = Double.parseDouble(tokens[2]);
                        if (plantRatingMap.get(plant) == 0) {
                            plantRatingMap.put(plant, rating);
                        } else {
                            double averageRating = (plantRatingMap.get(plant) + rating) / 2;
                            plantRatingMap.put(plant, averageRating);
                        }
                        break;
                    case "Update":
                        int rarity = Integer.parseInt(tokens[2]);
                        plantRarityMap.put(plant, rarity);
                        break;
                    case "Reset":
                        plantRatingMap.put(plant, 0.0);
                        break;
                }
            }
            else {
                System.out.println("error");
            }
            command = scan.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : plantRarityMap.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), plantRatingMap.get(entry.getKey()));
        }

    }
}
