import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstPlayerCards = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0) {
            int deckFirstPlayer = firstPlayerCards.get(0);
            int deckSecondPlayer = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (deckFirstPlayer > deckSecondPlayer) {
                firstPlayerCards.add(deckFirstPlayer);
                firstPlayerCards.add(deckSecondPlayer);
            }
            else if (deckSecondPlayer > deckFirstPlayer) {
                secondPlayerCards.add(deckSecondPlayer);
                secondPlayerCards.add(deckFirstPlayer);
            }

            if (firstPlayerCards.size() == 0) {
                System.out.printf("Second player wins! Sum: %d", getCardsSum(secondPlayerCards));
            }
            else if (secondPlayerCards.size() == 0) {
                System.out.printf("First player wins! Sum: %d", getCardsSum(firstPlayerCards));
            }
        }
    }

    private static int getCardsSum(List<Integer> cards) {
        int sum = 0;
        for (int currentCard : cards) {
            sum += currentCard;
        }
        return sum;
    }
}
