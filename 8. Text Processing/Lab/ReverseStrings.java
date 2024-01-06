import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        while (!command.equals("end")) {
            String text = command;

            String reversedText = "";
            for (int i = text.length() - 1; i >= 0; i--) {
                reversedText += text.charAt(i);
            }
            System.out.println(text + " = " + reversedText);
            command = scan.nextLine();
        }
    }
}