import java.util.Scanner;

public class ReverseArrayStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] symbolsArr = scan.nextLine().split(" ");

        for (int i = 0; i < symbolsArr.length / 2; i++) {
            String oldElement = symbolsArr[i];
            symbolsArr[i] = symbolsArr[symbolsArr.length - 1 - i];
            symbolsArr[symbolsArr.length - 1 - i] = oldElement;
        }
        System.out.printf(String.join(" ", symbolsArr));
    }
}
