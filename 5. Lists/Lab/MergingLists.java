import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstNumbersList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNumbersList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int minSize = Math.min(firstNumbersList.size(), secondNumbersList.size());
        for (int i = 0; i < minSize; i++) {
            int numFirstList = firstNumbersList.get(i);
            int numSecondList = secondNumbersList.get(i);

            resultList.add(numFirstList);
            resultList.add(numSecondList);
        }

        if (firstNumbersList.size() > secondNumbersList.size()) {
            resultList.addAll(firstNumbersList.subList(minSize, firstNumbersList.size()));
        } else {
            resultList.addAll(secondNumbersList.subList(minSize, secondNumbersList.size()));
        }

        System.out.print(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}
