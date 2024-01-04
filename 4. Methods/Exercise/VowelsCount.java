import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputText = scan.nextLine();
        printCountVowels(inputText.toLowerCase());
    }
    public static void printCountVowels(String text) {
        int countVowels = 0;
        for (char letter : text.toCharArray()) {
            switch (letter) {
                case 'a':
                case 'o':
                case 'u':
                case 'e':
                case 'i':
                    countVowels++;
            }
        }
        System.out.println(countVowels);
    }
}
