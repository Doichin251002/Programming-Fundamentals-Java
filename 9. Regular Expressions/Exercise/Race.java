import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> listRacers = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        Map<String, Integer> mapRacers = new LinkedHashMap<>();
        listRacers.forEach(name -> mapRacers.put(name, 0));

        Pattern patternLetters = Pattern.compile("[A-Za-z]+");
        Pattern patternDigits = Pattern.compile("\\d");

        String racerDataLine = scan.nextLine();
        while (!racerDataLine.equals("end of race")) {
            StringBuilder racerName = new StringBuilder();
            Matcher matcherLetters = patternLetters.matcher(racerDataLine);
            while (matcherLetters.find()) {
                racerName.append(matcherLetters.group());
            }

            int score = 0;
            Matcher matcherDigits = patternDigits.matcher(racerDataLine);
            while (matcherDigits.find()) {
                score += Integer.parseInt(matcherDigits.group());
            }

            if (listRacers.contains(racerName.toString())) {
                int currentScore = mapRacers.get(racerName.toString());
                mapRacers.put(racerName.toString(), currentScore + score);
            }

            racerDataLine = scan.nextLine();
        }

        List<String> top3Racers = mapRacers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + top3Racers.get(0));
        System.out.println("2nd place: " + top3Racers.get(1));
        System.out.println("3rd place: " + top3Racers.get(2));
    }
}
