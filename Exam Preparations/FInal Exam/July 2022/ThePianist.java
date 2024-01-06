import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, String> piecesComposer = new TreeMap<>();
        Map<String, String> piecesKey = new TreeMap<>();

        String piece;
        String composer;
        String key;
        for (int i = 1; i <= n; i++) {
            String[] pieceTokens = scan.nextLine().split("\\|");
            piece = pieceTokens[0];
            composer = pieceTokens[1];
            key = pieceTokens[2];

            piecesComposer.put(piece, composer);
            piecesKey.put(piece, key);
        }

        String command = scan.nextLine();
        while (!command.equals("Stop")) {
            String[] operationTokens = command.split("\\|");
            String operation = operationTokens[0];
            piece = operationTokens[1];
            switch (operation) {
                case "Add":
                    composer = operationTokens[2];
                    key = operationTokens[3];

                    if (!piecesComposer.containsKey(piece)) {
                        piecesComposer.put(piece, composer);
                        piecesKey.put(piece, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    } else {
                        System.out.println(piece + " is already in the collection!");
                    }
                    break;
                case "Remove":
                    if (piecesComposer.containsKey(piece)) {
                        piecesComposer.remove(piece);
                        piecesKey.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = operationTokens[2];

                    if (piecesComposer.containsKey(piece)) {
                        key = newKey;
                        piecesKey.put(piece, key);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        piecesComposer.forEach((key1, value1) -> System.out.printf("%s -> Composer: %s, Key: %s%n", key1, value1, piecesKey.get(key1)));
    }
}
