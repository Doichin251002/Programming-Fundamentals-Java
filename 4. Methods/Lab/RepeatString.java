import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputText = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());

        String resultText = (repeatText(inputText, n));
        System.out.println(resultText);
    }

    public static String repeatText(String text, int repeat) {
        String result = "";
        for (int i = 0; i < repeat; i++) {
            result += text;
        }
        return result;
    }
}
