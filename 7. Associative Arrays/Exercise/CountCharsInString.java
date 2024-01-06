import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String textLine = scan.nextLine().replaceAll(" ", "");

        LinkedHashMap<Character, Integer> textMap = new LinkedHashMap<>();
        for (int i = 0; i < textLine.length(); i++) {
            char letter = textLine.charAt(i);
            textMap.putIfAbsent(letter, 0);
            textMap.put(letter, textMap.get(letter) + 1);
        }

        for (Map.Entry<Character, Integer> entry : textMap.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}