import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] ticketsArr = scan.nextLine().split(" *,+ +");

        Pattern pattern = Pattern.compile("[@#$^]+");

        for (String currentTicket : ticketsArr) {
            if (currentTicket.length() == 20) {

                String leftHalfTicket = currentTicket.substring(0, 10);
                String rightHalfTicket = currentTicket.substring(10, 20);

                Matcher leftPartMatcher = pattern.matcher(leftHalfTicket);
                Matcher rightPartMatcher = pattern.matcher(rightHalfTicket);

                if (leftPartMatcher.find() && rightPartMatcher.find()) {
                    if (leftPartMatcher.group().equals(rightPartMatcher.group())) {
                        int lengthSymbols = leftPartMatcher.group().length();
                        char winningSymbol = leftPartMatcher.group().charAt(0);

                        if (lengthSymbols >= 6 && lengthSymbols <= 9) {
                            System.out.printf("ticket \"%s\" - %d%c", currentTicket, lengthSymbols, winningSymbol);
                        } else if (lengthSymbols == 10) {
                            System.out.printf("ticket \"%s\" - %d%c Jackpot!", currentTicket, lengthSymbols, winningSymbol);
                        }
                    } else {
                        System.out.printf("ticket \"%s\" - no match", currentTicket);
                    }
                } else if (!(leftPartMatcher.find() && rightPartMatcher.find())) {
                    System.out.printf("ticket \"%s\" - no match", currentTicket);
                }
            } else {
                System.out.print("invalid ticket");
            }
            System.out.println();
        }
    }
}