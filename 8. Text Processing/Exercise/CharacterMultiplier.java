import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] textArr = scan.nextLine().split(" ");
        String firstText = textArr[0];
        String secondText = textArr[1];

        int maxLength;
        int minLength;
        String textMaxLength;
        if (firstText.length() > secondText.length()) {
            textMaxLength = firstText;
            maxLength = firstText.length();
            minLength = secondText.length();
        } else {
            textMaxLength = secondText;
            maxLength = secondText.length();
            minLength = firstText.length();
        }
        System.out.println(getSum(firstText, secondText, textMaxLength, maxLength, minLength));
    }
    private static int getSum(String firstText, String secondText, String textMaxLength, int maxLength, int minLength) {
        int sum = 0;
        for (int i = 0; i < maxLength; i++) {
            if (i >= minLength) {
                sum += textMaxLength.charAt(i);
            }
            else {
                sum += firstText.charAt(i) * secondText.charAt(i);
            }
        }
        return sum;
    }
}
