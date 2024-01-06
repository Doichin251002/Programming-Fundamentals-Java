import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] wordsArr = scan.nextLine().split(" ");

        List<String> repeatList = new ArrayList<>();
        for (String currWord : wordsArr) {
            int length = currWord.length();

            String repeatWord = repeatString(currWord, length);
            repeatList.add(repeatWord);
        }

        System.out.println(String.join("", repeatList));
    }

    public static String repeatString(String word, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += word;
        }
        return result;
    }
}
