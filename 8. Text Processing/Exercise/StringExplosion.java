import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder textBuilder = new StringBuilder(scan.nextLine());

        int totalExplosionStrength = 0;
        for (int i = 0; i <= textBuilder.length() - 1; i++) {
            char currSymbol = textBuilder.charAt(i);

            if (currSymbol == '>') {
                int explosionStrength = Integer.parseInt(textBuilder.charAt(i + 1) + "");
                totalExplosionStrength += explosionStrength;
            } else if (currSymbol != '>' && totalExplosionStrength > 0) {
                textBuilder.deleteCharAt(i);
                totalExplosionStrength--;
                i--;
            }
        }
        System.out.println(textBuilder);
    }
}
