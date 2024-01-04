import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersList = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        String[] manipulatingNumbers = scanner.nextLine().split("\\s+");
        String bombNumber = manipulatingNumbers[0];
        int power = Integer.parseInt(manipulatingNumbers[1]);

        while (numbersList.contains(bombNumber)){
            int elementIndex = numbersList.indexOf(bombNumber);

            int left = Math.max(0, elementIndex - power);
            int right = Math.min(elementIndex + power, numbersList.size() - 1);

            if (right >= left) {
                numbersList.subList(left, right + 1).clear();
            }
        }
        System.out.println(numbersList.stream().mapToInt(Integer::parseInt).sum());
    }
}
