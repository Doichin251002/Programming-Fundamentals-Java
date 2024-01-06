import java.util.LinkedHashMap;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int goal = 250;
        boolean isGoalReached = false;
        String legendaryItem = "";

        LinkedHashMap<String, Integer> junkMaterialsMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> keyMaterialsMap = new LinkedHashMap<>();
        keyMaterialsMap.put("shards", 0);
        keyMaterialsMap.put("fragments", 0);
        keyMaterialsMap.put("motes", 0);

        while (!isGoalReached) {
            String inputLine = scan.nextLine();
            for (int i = 0; i < inputLine.split(" ").length / 2; i++) {
                int quantity = Integer.parseInt(inputLine.split(" ")[i + i]);
                String item = inputLine.split(" ")[i + i + 1].toLowerCase();

                switch (item) {
                    case "shards":
                        keyMaterialsMap.put(item, keyMaterialsMap.get(item) + quantity);
                        if (keyMaterialsMap.get(item) >= goal) {
                            keyMaterialsMap.put(item, keyMaterialsMap.get(item) - goal);
                            legendaryItem = "Shadowmourne";
                            isGoalReached = true;
                        }
                        break;
                    case "fragments":
                        keyMaterialsMap.put(item, keyMaterialsMap.get(item) + quantity);
                        if (keyMaterialsMap.get(item) >= goal) {
                            keyMaterialsMap.put(item, keyMaterialsMap.get(item) - goal);
                            legendaryItem = "Valanyr";
                            isGoalReached = true;
                        }
                        break;
                    case "motes":
                        keyMaterialsMap.put(item, keyMaterialsMap.get(item) + quantity);
                        if (keyMaterialsMap.get(item) >= goal) {
                            keyMaterialsMap.put(item, keyMaterialsMap.get(item) - goal);
                            legendaryItem = "Dragonwrath";
                            isGoalReached = true;
                        }
                        break;
                    default:
                        junkMaterialsMap.putIfAbsent(item, 0);
                        junkMaterialsMap.put(item, junkMaterialsMap.get(item) + quantity);
                        break;
                }
                if (isGoalReached) {
                    break;
                }
            }
        }

        System.out.println(legendaryItem + " obtained!");
        keyMaterialsMap.forEach((key, value) -> System.out.println(key + ": " + value));
        junkMaterialsMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
