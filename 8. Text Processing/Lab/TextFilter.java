import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] bannedWordsArr = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String banWord : bannedWordsArr) {
            text = text.replace(banWord, repeatString("*", banWord.length()));
        }
        System.out.println(text);
    }

    public static String repeatString(String s, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += s;
        }
        return result;
    }
}
