import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Integer> carMileage = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        String [] tokens;
        String car;
        int kilometers;
        int fuel;
        for (int i = 0; i < n; i++) {
            tokens = scan.nextLine().split("\\|");
            car = tokens[0];
            kilometers = Integer.parseInt(tokens[1]);
            fuel = Integer.parseInt(tokens[2]);

            carMileage.put(car, kilometers);
            carFuel.put(car, fuel);
        }

        String command = scan.nextLine();
        while (!command.equals("Stop")) {
            tokens = command.split(" : ");
            String operation = tokens[0];
            car = tokens[1];
            switch (operation) {
                case "Drive":
                    kilometers = Integer.parseInt(tokens[2]);
                    fuel = Integer.parseInt(tokens[3]);

                    if (carFuel.get(car) >= fuel) {
                        carMileage.put(car, carMileage.get(car) + kilometers);
                        carFuel.put(car, carFuel.get(car) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, kilometers, fuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }

                    if (carMileage.get(car) >= 100000) {
                        carMileage.remove(car);
                        carFuel.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(tokens[2]);

                    if (carFuel.get(car) + fuel > 75) {
                        fuel = 75 - carFuel.get(car);
                        carFuel.put(car, 75);
                    } else {
                        carFuel.put(car, carFuel.get(car) + fuel);
                    }
                    System.out.printf("%s refueled with %d liters%n", car, fuel);
                    break;
                case "Revert":
                    kilometers = Integer.parseInt(tokens[2]);

                    if (carMileage.get(car) - kilometers < 10000) {
                        carMileage.put(car, 10000);
                    } else {
                        carMileage.put(car, carMileage.get(car) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        carMileage.forEach((key, value) -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", key, value, carFuel.get(key)));
    }
}
