import java.util.*;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandTokens = command.split("\\s+");

            String action = commandTokens[0];
            int index = Integer.parseInt(commandTokens[1]);
            int value = Integer.parseInt(commandTokens[2]);

            switch (action) {
                case "Shoot":
                    if (isValidIndex(targetNumbers, index)) {
                        Integer currentTargetNumber = targetNumbers.get(index);
                        targetNumbers.set(index, currentTargetNumber - value);

                        if (targetNumbers.get(index) <= 0) {
                            targetNumbers.remove(targetNumbers.get(index));
                        }
                    }
                    break;
                case "Add":
                    if (isValidIndex(targetNumbers, index)) {
                        targetNumbers.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (isValidIndex(targetNumbers, index)) {
                        int bottomBoundaryIndex = index - value;
                        int topBoundaryIndex = index + value;

                        if (isValidIndex(targetNumbers, bottomBoundaryIndex) &&
                                isValidIndex(targetNumbers, topBoundaryIndex)) {
                            List<Integer> numbersForRemoving = targetNumbers
                                    .subList(bottomBoundaryIndex, ++topBoundaryIndex);

                            targetNumbers.removeAll(numbersForRemoving);
                        } else {
                            System.out.println("Strike missed!");
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(targetNumbers
                .toString()
                .replaceAll("[\\[\\]]+", "")
                .replaceAll(", ", "|")
                .trim());
    }

    public static boolean isValidIndex(List<Integer> numbers, int index) {
        return index >= 0 && index < numbers.size();
    }
}
