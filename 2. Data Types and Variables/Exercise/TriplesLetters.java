import java.util.Scanner;

public class TriplesLetters {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (char firstLetter = 'a'; firstLetter < ('a' + n); firstLetter++) {
            for (char secondLetter = 'a'; secondLetter < ('a' + n); secondLetter++) {
                for (char thirdLetter = 'a'; thirdLetter < ('a' + n); thirdLetter++) {
                    System.out.printf("%c%c%c%n", firstLetter, secondLetter, thirdLetter);
                }
            }
        }
    }
}
