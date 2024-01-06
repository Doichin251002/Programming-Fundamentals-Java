import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double [] numbersArr = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        TreeMap<Double, Integer> countMap = new TreeMap<>();
        for (double num : numbersArr) {
                countMap.putIfAbsent(num, 0);
                countMap.put(num, countMap.get(num) + 1);
        }
        for (Map.Entry<Double, Integer> entry : countMap.entrySet()) {
            double key = entry.getKey();
            int value = entry.getValue();
            System.out.printf("%.0f -> %d%n", key, value);
        }
    }
}