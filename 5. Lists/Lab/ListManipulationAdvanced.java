import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] commandInput = command.split(" ");
            command = commandInput[0];

            switch (command) {
                case "Contains":
                    int manipulatingNum = Integer.parseInt(commandInput[1]);
                    if (numbersList.contains(manipulatingNum)) {
                        System.out.print("Yes");
                    } else {
                        System.out.print("No such number");
                    }
                    break;
                case "Print":
                    String result = commandInput[1];
                    if (result.equals("even"))
                        for (int currentNum : numbersList) {
                            if (currentNum % 2 == 0) {
                                System.out.print(currentNum + " ");
                            }
                        }
                    else {
                        for (int currentNum : numbersList) {
                            if (currentNum % 2 != 0) {
                                System.out.print(currentNum + " ");
                            }
                        }
                    }
                    break;
                case "Get":
                    int sum = numbersList.stream().mapToInt(Integer::intValue).sum();
                    System.out.print(sum);
                    break;
                case "Filter":
                    String symbol = commandInput[1];
                    manipulatingNum = Integer.parseInt(commandInput[2]);
                    for (int currentNum : numbersList) {
                        boolean condition = false;
                        switch (symbol) {
                            case "<":
                                condition = currentNum < manipulatingNum;
                                break;
                            case "<=":
                                condition = currentNum <= manipulatingNum;
                                break;
                            case ">":
                                condition = currentNum > manipulatingNum;
                                break;
                            case ">=":
                                condition = currentNum >= manipulatingNum;
                                break;
                        }
                        if (condition) {
                            System.out.print(currentNum + " ");
                        }
                    }
                    break;
            }
            System.out.println();
            command = scan.nextLine();
        }
    }
}
