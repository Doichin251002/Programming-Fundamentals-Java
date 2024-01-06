import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder destinationsLine = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("Travel")) {
            String [] tokens = command.split(":");
            String operation = tokens[0];
            switch (operation) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index <= destinationsLine.length()) {
                        String newDestination = tokens[2];
                        destinationsLine.insert(index, newDestination);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex < destinationsLine.length()) {
                        destinationsLine.delete(startIndex, endIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    if (destinationsLine.toString().contains(oldString)) {
                        String changedDestination = destinationsLine.toString().replaceAll(oldString, newString);
                        destinationsLine.setLength(0);
                        destinationsLine.append(changedDestination);
                    }
                    break;
            }
            System.out.println(destinationsLine);
            command = scan.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + destinationsLine);
    }
}
