import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbersArr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String commandInput = scan.nextLine();
        while (!commandInput.equals("end")) {
            String operation = commandInput.split(" ")[0];

            switch (operation) {
                case "swap":
                    int index1 = Integer.parseInt(commandInput.split(" ")[1]);
                    int index2 = Integer.parseInt(commandInput.split(" ")[2]);
                    int swappedElement = numbersArr[index1];
                    numbersArr[index1] = numbersArr[index2];
                    numbersArr[index2] = swappedElement;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commandInput.split(" ")[1]);
                    index2 = Integer.parseInt(commandInput.split(" ")[2]);
                    int product = numbersArr[index1] * numbersArr[index2];
                    numbersArr[index1] = product;
                    break;
                case "decrease":
                    for (int i = 0; i < numbersArr.length; i++) {
                        numbersArr[i]--;
                    }
                    break;
            }
            commandInput = scan.nextLine();
        }

        System.out.println(Arrays.toString(numbersArr).replaceAll("[\\[\\]]", ""));
    }
}
