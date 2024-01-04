import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> itemsList = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        String commandInput = scan.nextLine();
        while (!commandInput.equals("Craft!")) {
            String [] commandLine = commandInput.split(" - ");
            String operation = commandLine[0];

            switch (operation) {
                case "Collect":
                    String firstElement = commandLine[1];
                    if (!itemsList.contains(firstElement)) {
                        itemsList.add(firstElement);
                    }
                    break;
                case "Drop":
                    firstElement = commandLine[1];
                        itemsList.remove(firstElement);
                    break;
                case "Combine Items":
                    String [] elements = commandLine[1].split(":");
                    firstElement = elements[0];
                    String secondElement = elements[1];
                    if (itemsList.contains(firstElement)) {
                        int indexElement1 = itemsList.indexOf(firstElement) + 1;
                        itemsList.add(indexElement1, secondElement);
                    }
                    break;
                case "Renew":
                    firstElement = commandLine[1];
                    if (itemsList.contains(firstElement)) {
                        itemsList.remove(firstElement);
                        itemsList.add(firstElement);
                    }
                    break;
            }
            commandInput = scan.nextLine();
        }
        System.out.println(String.join(", ", itemsList));
    }
}
