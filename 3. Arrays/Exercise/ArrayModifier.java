import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersArr = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.contains("swap")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int element1 = numbersArr[index1];
                int element2 = numbersArr[index2];

                numbersArr[index1] = element2;
                numbersArr[index2] = element1;
            }
            else if (command.contains("multiply")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int element1 = numbersArr[index1];
                int element2 = numbersArr[index2];

                int product = element1 * element2;

                numbersArr[index1] = product;
            }
            else if (command.equals("decrease")) {
                for (int index = 0; index <= numbersArr.length - 1; index++) {
                    numbersArr[index]--;
                }
            }
            command = scan.nextLine();
        }

        for (int i = 0; i <= numbersArr.length - 1; i++) {
            if (i < numbersArr.length - 1) {
                System.out.print(numbersArr[i] + ", ");
            }
            else {
                System.out.print(numbersArr[i]);
            }
        }
    }
}
