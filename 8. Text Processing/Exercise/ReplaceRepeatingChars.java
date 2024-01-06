import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder textBuilder = new StringBuilder(scan.nextLine());

        for (int i = 0; i <= textBuilder.length() - 2; i++) {
            if (textBuilder.charAt(i) == textBuilder.charAt(i + 1)) {
                textBuilder.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(textBuilder);
    }
}
