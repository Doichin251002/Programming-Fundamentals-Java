import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String textInput = scan.nextLine();
        printMiddleSymbol(textInput);
    }

    public static void printMiddleSymbol(String text) {
        int length = text.length();
        if (text.length() % 2 == 0) {
            char middleSymbol = text.charAt(length/ 2 - 1);
            System.out.print(middleSymbol);
        }
        char middleSymbol = text.charAt(length/ 2);
        System.out.print(middleSymbol);
    }
}
