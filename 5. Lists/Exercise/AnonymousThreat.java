import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> textList = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String inputData = scan.nextLine();
        while (!inputData.equals("3:1")) {
            String command = inputData.split(" ")[0];
            int startIndex = Integer.parseInt(inputData.split(" ")[1]);

            if (command.equals("merge")) {
                int endIndex = Integer.parseInt(inputData.split(" ")[2]);
                if (startIndex >= 0 && endIndex <= textList.size() - 1) {
                    mergeElements(textList, startIndex, endIndex);
                } else if (startIndex < 0) {
                    mergeElements(textList, 0, textList.size() - 1);
                } else if (endIndex > textList.size() - 1) {
                    mergeElements(textList, startIndex, textList.size() - 1);
                }
            } else if (command.equals("divide")) {
                int partitions = Integer.parseInt(inputData.split(" ")[2]);
                String dividingText = textList.get(startIndex);
                textList.remove(dividingText);

                int substringLength = (dividingText.length()) / partitions;
                int startIndexText = 0;
                for (int i = 1; i < partitions; i++) {
                    textList.add(startIndex, dividingText.substring(startIndexText, startIndexText + substringLength));
                    startIndex++;
                    startIndexText += substringLength;
                }
                textList.add(startIndex, dividingText.substring(startIndexText));
            }

            inputData = scan.nextLine();
        }
        System.out.println(textList.toString().replaceAll("[\\[\\],]", "")
                .replaceAll("\\s+", " ")
                .trim());
    }

    private static void mergeElements(List<String> textList, int startIndex, int endIndex) {
        String concatenatedText = "";
        for (int i = startIndex; i <= endIndex; i++) {
            concatenatedText += textList.get(i);
        }
        textList.removeAll(textList.subList(startIndex, endIndex + 1));
        textList.add(startIndex, concatenatedText);
    }
}
