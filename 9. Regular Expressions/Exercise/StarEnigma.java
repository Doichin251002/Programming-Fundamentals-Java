import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countMessages = Integer.parseInt(scan.nextLine());

        Pattern patternKey = Pattern.compile("[SsTtAaRr]");
        Pattern patternMessage = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<attack>[AD]?)![^@\\-!:>]*\\->(?<count>\\d+)");

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < countMessages; i++) {
            String encryptedMessage = scan.nextLine();

            int decryptionKey = 0;
            Matcher matcherKey = patternKey.matcher(encryptedMessage);
            while (matcherKey.find()) {
                decryptionKey++;
            }

            StringBuilder decryptedMessageBuild = new StringBuilder();
            for (char currentSymbol : encryptedMessage.toCharArray()) {
                decryptedMessageBuild.append((char)(currentSymbol - decryptionKey));
            }
            String decryptedMessage = decryptedMessageBuild.toString();

            Matcher matcherMessage = patternMessage.matcher(decryptedMessage);
            if (matcherMessage.find()) {
                String namePlanet = matcherMessage.group("name");
                char attackType = matcherMessage.group("attack").charAt(0);
                switch (attackType) {
                    case 'A':
                        attackedPlanets.add(namePlanet);
                        break;
                    case 'D':
                        destroyedPlanets.add(namePlanet);
                        break;
                }
            }
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.println("Attacked planets: " + attackedPlanets.size());
        if (attackedPlanets.size() > 0) {
            attackedPlanets.forEach(planet -> System.out.println("-> " + planet));
        }
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        if (destroyedPlanets.size() > 0) {
            destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
        }
    }
}
