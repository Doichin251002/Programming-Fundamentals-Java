import java.util.Scanner;

public class ImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] commandTokens = command.split("\\|");
            String action = commandTokens[0];

            switch (action) {
                case "Move":
                    int lettersLength = Integer.parseInt(commandTokens[1]);

                    String movingSubstring = message.substring(0, lettersLength);
                    message.replace(0, lettersLength, "");
                    message.append(movingSubstring);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandTokens[1]);
                    String value = commandTokens[2];

                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = commandTokens[1];
                    String replacement = commandTokens[2];

                    message.replace(0, message.length(), message.toString().replace(substring, replacement));
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", message.toString());
    }
}