import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> demonsNameList = Arrays.stream(scan.nextLine().split(",\\s*")).collect(Collectors.toList());

        Map<String, List<Double>> demonsMap = new TreeMap<>();
        demonsNameList.forEach(name -> demonsMap.put(name, new ArrayList<>(Arrays.asList(0.0, 0.0))));

        Pattern patternHealth = Pattern.compile("[^0-9+\\-*\\/\\.]");
        Pattern patternDamage = Pattern.compile("[+-]?[\\d\\.?\\d]+");
        Pattern patternBoost = Pattern.compile("[\\*\\/]");

        for (String currentDemon : demonsNameList) {
            currentDemon = currentDemon.replaceAll("\\s+", "");

            int health = 0;
            Matcher matcherHealth = patternHealth.matcher(currentDemon);
            while (matcherHealth.find()) {
                health += matcherHealth.group().charAt(0);
            }
            double oldHealth = demonsMap.get(currentDemon).get(0);
            demonsMap.get(currentDemon).set(0, oldHealth + (double)health);

            double damage = 0;
            Matcher matcherDamage = patternDamage.matcher(currentDemon);
            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group());
            }

            Matcher matcherBoost = patternBoost.matcher(currentDemon);
            while (matcherBoost.find()) {
                switch (matcherBoost.group()) {
                    case "*":
                        damage *= 2;
                        break;
                    case "/":
                        damage /= 2;
                        break;
                }
            }
            double oldDamage = demonsMap.get(currentDemon).get(1);
            demonsMap.get(currentDemon).set(1, oldDamage + damage);
        }

        demonsMap.forEach((key, value) -> System.out.printf("%s - %.0f health, %.2f damage%n",
                key, value.get(0), value.get(1)));
    }
}
