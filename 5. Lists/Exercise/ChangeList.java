import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();
        while (!input.equals("end")) {
            String [] command = input.split(" ");
            String manipulatingList = command[0];
            int manipulatingNum = Integer.parseInt(command[1]);

            if (manipulatingList.equals("Delete")) {
                numbersList.removeAll(Arrays.asList(manipulatingNum));
            } else if (manipulatingList.equals("Insert")) {
                int index = Integer.parseInt(command[2]);
                numbersList.add(index, manipulatingNum);
            }
            input = scan.nextLine();
        }
        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
