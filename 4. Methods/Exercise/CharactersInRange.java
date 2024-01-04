import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char symbol1 = scan.nextLine().charAt(0);
        char symbol2 = scan.nextLine().charAt(0);

        printSymbolsInRange(symbol1, symbol2);
    }

    public static void printSymbolsInRange(char startSymbol, char endSymbol) {
        if (startSymbol > endSymbol) {
            char tempSymbol = startSymbol;
            startSymbol = endSymbol;
            endSymbol = tempSymbol;
        }
        for (char currentSymbol = (char) (startSymbol + 1); currentSymbol < endSymbol; currentSymbol++) {
            System.out.print(currentSymbol + " ");
        }
    }
}
