import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<word>[A-Za-z]{3,})(\\1){2}(?<mirror>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(inputLine);

        Map<String, String> wordsMap = new LinkedHashMap<>();
        int countWords = 0;
        while (matcher.find()) {
            countWords++;
            String word = matcher.group("word");
            String mirrorWord = matcher.group("mirror");
            StringBuilder sb = new StringBuilder(mirrorWord);

            if (sb.reverse().toString().equals(word)) {
                wordsMap.put(word, mirrorWord);
            }
        }

        if (countWords > 0) {
            System.out.printf("%d word pairs found!%n", countWords);
        } else {
            System.out.println("No word pairs found!");
        }

        if (wordsMap.size() > 0) {
            System.out.println("The mirror words are:");
            List<String> pairWords = new ArrayList<>();

            wordsMap.forEach((key, value) -> pairWords.add(String.format("%s <=> %s", key, value)));
            System.out.print(String.join(", ", pairWords));
            } else {
                System.out.println("No mirror words!");
            }
        }
    }
