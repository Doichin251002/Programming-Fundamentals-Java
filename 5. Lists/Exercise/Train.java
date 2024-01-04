import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagonList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());
        int capacityWagon = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();
        while (!input.equals("end")) {
            String [] command = input.split(" ");

            if (command[0].equals("Add")) {
                int manipulatingNum = Integer.parseInt(command[1]);
                wagonList.add(manipulatingNum);
            } else {
                int manipulatingNum = Integer.parseInt(command[0]);

                for (int i = 0; i < wagonList.size(); i++) {
                    int passengers = wagonList.get(i);
                    if ((passengers + manipulatingNum) <= capacityWagon) {
                        passengers += manipulatingNum;
                        wagonList.add(i, passengers);
                        wagonList.remove(i + 1);
                        break;
                    }
                }
            }
            input = scan.nextLine();
        }

        System.out.println(wagonList.toString().replaceAll("[\\[\\],]", ""));
    }
}