import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String [] commandInput = command.split(" ");
            command = commandInput[0];
            int manipulatingNum = Integer.parseInt(commandInput[1]);

            switch (command) {
                case "Add":
                    numbersList.add(manipulatingNum);
                    break;
                case "Remove":
                    numbersList.remove(Integer.valueOf(manipulatingNum));
                    break;
                case "RemoveAt":
                    numbersList.remove(manipulatingNum);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandInput[2]);
                    numbersList.add(index, manipulatingNum);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.print(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
