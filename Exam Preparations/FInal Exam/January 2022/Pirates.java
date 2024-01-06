import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> cityPopulation = new LinkedHashMap<>();
        Map<String, Integer> cityGold = new LinkedHashMap<>();

        String command = scan.nextLine();
        String city;
        int people;
        int gold;
        while (!command.equals("Sail")) {
            String[] cityTokens = command.split("\\|{2}");
            city = cityTokens[0];
            people = Integer.parseInt(cityTokens[1]);
            gold = Integer.parseInt(cityTokens[2]);

            cityPopulation.putIfAbsent(city, 0);
            cityPopulation.put(city, cityPopulation.get(city) + people);

            cityGold.putIfAbsent(city, 0);
            cityGold.put(city, cityGold.get(city) + gold);

            command = scan.nextLine();
        }

        command = scan.nextLine();
        while (!command.equals("End")) {
            String[] eventTokens = command.split("=>");
            String operation = eventTokens[0];
            city = eventTokens[1];

            if (cityPopulation.containsKey(city)) {
                switch (operation) {
                    case "Plunder":
                        people = Integer.parseInt(eventTokens[2]);
                        gold = Integer.parseInt(eventTokens[3]);

                        cityPopulation.put(city, cityPopulation.get(city) - people);
                        cityGold.put(city, cityGold.get(city) - gold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);

                        if (cityPopulation.get(city) <= 0 || cityGold.get(city) <= 0) {
                            cityPopulation.remove(city);
                            cityGold.remove(city);
                            System.out.printf("%s has been wiped off the map!%n", city);
                        }
                        break;
                    case "Prosper":
                        gold = Integer.parseInt(eventTokens[2]);

                        if (gold > 0) {
                            cityGold.put(city, cityGold.get(city) + gold);
                            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city, cityGold.get(city));
                        } else {
                            System.out.println("Gold added cannot be a negative number!");
                        }
                        break;
                }
            }
            command = scan.nextLine();
        }
        if (cityPopulation.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityPopulation.size());
            cityPopulation.forEach((key, value) -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key, value, cityGold.get(key)));
        }
        else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
