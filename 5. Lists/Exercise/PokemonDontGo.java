import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sumRemoved = 0;
        while (numbersList.size() > 0) {
            int index = Integer.parseInt(scan.nextLine());

            if (index >= 0 && index <= numbersList.size() - 1) {
                int removedNumber = numbersList.get(index);
                numbersList.remove(index);
                sumRemoved += removedNumber;
                modifyList(numbersList, removedNumber);
            } else if (index < 0) {
                int firstElement = numbersList.get(0);
                numbersList.remove(0);
                sumRemoved += firstElement;
                int lastElement = numbersList.get(numbersList.size() - 1);
                numbersList.add(0, lastElement);

                modifyList(numbersList, firstElement);
            } else if (index > numbersList.size() - 1){
                int lastElement = numbersList.get(numbersList.size() - 1);
                numbersList.remove(numbersList.size() - 1);
                sumRemoved += lastElement;
                int firstElement = numbersList.get(0);
                numbersList.add(firstElement);

                modifyList(numbersList, lastElement);
            }
        }

        System.out.println(sumRemoved);
    }

    private static void modifyList(List<Integer> numbersList, int removedNumber) {
        for (int indexInList = 0; indexInList < numbersList.size(); indexInList++) {
            int currentIndex = numbersList.get(indexInList);

            if (currentIndex <= removedNumber) {
                currentIndex += removedNumber;
            } else {
                currentIndex -= removedNumber;
            }
            numbersList.set(indexInList, currentIndex);
        }
    }
}
