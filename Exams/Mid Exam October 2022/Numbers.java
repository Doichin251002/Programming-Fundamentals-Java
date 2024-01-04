import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("Finish")) {
            String operation = command.split(" ")[0];
            int number1 = Integer.parseInt(command.split(" ")[1]);

            switch (operation) {
                case "Add":
                    numbersList.add(number1);
                    break;
                case "Remove":
                    numbersList.remove(Integer.valueOf(number1));
                    break;
                case "Replace":
                    int replacementNumber = Integer.parseInt(command.split(" ")[2]);
                    if (numbersList.contains(number1)) {
                        int index = numbersList.indexOf(number1);
                        numbersList.set(index, replacementNumber);
                    }
                    break;
                case "Collapse":
                    List<Integer> removingNumbers = new ArrayList<>();
                    for (int currentNum: numbersList) {
                        if (currentNum < number1) {
                            removingNumbers.add(currentNum);
                        }
                    }
                    numbersList.removeAll(removingNumbers);
            }
            command = scan.nextLine();
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
