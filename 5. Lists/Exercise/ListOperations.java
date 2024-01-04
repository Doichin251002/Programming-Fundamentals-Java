import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] commandInput = command.split(" ");
            command = commandInput[0];

            switch (command) {
                case "Add":
                    int manipulatingNum = Integer.parseInt(commandInput[1]);
                    numbersList.add(manipulatingNum);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandInput[1]);

                    if (isValidIndex(index, numbersList.size())) {
                        numbersList.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Insert":
                    manipulatingNum = Integer.parseInt(commandInput[1]);
                    index = Integer.parseInt(commandInput[2]);

                    if (isValidIndex(index, numbersList.size())) {
                        numbersList.add(index, manipulatingNum);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = commandInput[1];
                    manipulatingNum = Integer.parseInt(commandInput[2]);

                    if (direction.equals("left")) {
                        for (int i = 0; i < manipulatingNum; i++) {
                            int firstNum = numbersList.get(0);
                            numbersList.remove(0);
                            numbersList.add(firstNum);
                        }
                    }
                    else if (direction.equals("right")) {
                        for (int i = 0; i < manipulatingNum; i++) {
                            int lastNum = numbersList.get(numbersList.size() - 1);
                            numbersList.remove(numbersList.size() - 1);
                            numbersList.add(0, lastNum);
                        }
                    }
            }
            command = scan.nextLine();
        }
        System.out.print(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }

    public static boolean isValidIndex (int index, int sizeList) {
        return index >= 0 && index <= sizeList - 1;
    }
}
