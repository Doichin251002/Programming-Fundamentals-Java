import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Integer> heroesHP = new LinkedHashMap<>();
        Map<String, Integer> heroesMP = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String [] heroData = scan.nextLine().split(" ");
            String heroName = heroData[0];
            int hp = Integer.parseInt(heroData[1]);
            int mp = Integer.parseInt(heroData[2]);

            if (hp <= 100) {
                heroesHP.put(heroName, hp);
            }
            if (mp <= 200) {
                heroesMP.put(heroName, mp);
            }
        }

        String command = scan.nextLine();
        while (!command.equals("End")) {
            String [] tokens = command.split(" - ");
            String operation = tokens[0];
            String hero = tokens[1];
            int currentHP = heroesHP.get(hero);
            int currentMP = heroesMP.get(hero);
            switch (operation) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spell = tokens[3];

                    if (currentMP >= neededMP) {
                        currentMP -= neededMP;
                        heroesMP.put(hero, currentMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", hero, spell, currentMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", hero, spell);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    currentHP -= damage;

                    if (currentHP > 0) {
                        heroesHP.put(hero, currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero, damage, attacker, currentHP);
                    } else {
                        heroesHP.remove(hero);
                        System.out.printf("%s has been killed by %s!%n", hero, attacker);
                    }
                    break;
                case "Recharge":
                    int recoveredMP = Integer.parseInt(tokens[2]);
                    currentMP += recoveredMP;

                    if (currentMP > 200) {
                        currentMP = 200;
                    }

                    System.out.printf("%s recharged for %d MP!%n", hero, currentMP - heroesMP.get(hero));
                    heroesMP.put(hero, currentMP);
                    break;
                case "Heal":
                    int recoveredHP = Integer.parseInt(tokens[2]);
                    currentHP += recoveredHP;

                    if (currentHP > 100) {
                        currentHP = 100;
                    }

                    System.out.printf("%s healed for %d HP!%n", hero, currentHP - heroesHP.get(hero));
                    heroesHP.put(hero, currentHP);
                    break;
            }
            command = scan.nextLine();
        }

        heroesHP.forEach((key, value) -> {
            System.out.println(key);
            System.out.println("  HP: " + value);
            System.out.println("  MP: " + heroesMP.get(key));
        });
    }
}
