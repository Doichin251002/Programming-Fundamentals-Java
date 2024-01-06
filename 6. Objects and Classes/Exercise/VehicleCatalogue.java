import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }
        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }
        public String toString() {
            return String.format("Type: %s%n" +
                                 "Model: %s%n" +
                                 "Color: %s%n" +
                                 "Horsepower: %s",
                    getType().toUpperCase().charAt(0) + this.getType().substring(1), getModel(), getColor(), getHorsepower());
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        List<Vehicle> listVehicle = new ArrayList<>();
        while (!command.equals("End")) {
            String [] currentVehicle = command.split(" ");
            String type = currentVehicle[0];
            String model = currentVehicle[1];
            String color = currentVehicle[2];
            int horsepower = Integer.parseInt(currentVehicle[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);

            if (correctType(type) && correctModel(listVehicle, model) && correctCountVehicle(listVehicle)) {
                listVehicle.add(vehicle);
            }

            command = scan.nextLine();
        }

        while (!command.equals("Close the Catalogue")) {
            String model = command;

            for (Vehicle element: listVehicle) {
                if (model.equals(element.getModel())) {
                    System.out.println(element);
                }
            }
            command = scan.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepower(listVehicle, "car"));
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHorsepower(listVehicle, "truck"));
    }
    public static boolean correctType(String type) {
        return type.equals("car") || type.equals("truck");
    }
    public static boolean correctModel(List<Vehicle> listVehicle, String model) {
        for (Vehicle element : listVehicle) {
            if (model.equals(element.getModel())) {
                return false;
            }
        }
        return true;
    }
    public static boolean correctCountVehicle(List<Vehicle> listVehicle) {
        return listVehicle.size() <= 50;
    }
    public static double averageHorsepower(List<Vehicle> listVehicle, String model) {
        double sumHorsepower = 0;
        int countVehicle = 0;
        for (Vehicle element : listVehicle) {
            if (element.getType().equals(model)) {
                sumHorsepower += element.getHorsepower();
                countVehicle++;
            }
        }
        if (countVehicle == 0) {
            return 0;
        }
        else {
            return sumHorsepower / countVehicle;
        }
    }
}
