import java.util.Scanner;

public class PokeMon {public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int power = Integer.parseInt(scan.nextLine());
    int distance = Integer.parseInt(scan.nextLine());
    int factor = Integer.parseInt(scan.nextLine());

    int currentPower = power;
    int countPokes = 0;

    while (currentPower >= distance) {
        currentPower -= distance;
        countPokes++;
        if (currentPower == (power / 2)) {
            if (factor != 0) {
                currentPower /= factor;
            }
        }
    }
    System.out.println(currentPower);
    System.out.println(countPokes);
}
}
