import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String textArr = scan.nextLine();
        for (char symbol : textArr.toCharArray()) {
            System.out.print((char)(symbol + 3));
        }

    }
}
