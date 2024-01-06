import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder revealedMessage = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("Reveal")) {
            String [] tokens = command.split(":\\|:");

            int startIndex;
            String operation = tokens[0];
            switch (operation) {
                case "InsertSpace":
                    startIndex = Integer.parseInt(tokens[1]);
                    revealedMessage.insert(startIndex, " ");
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(tokens[1]);
                    if (revealedMessage.toString().contains(substring)) {
                        startIndex = revealedMessage.indexOf(String.valueOf(substring.charAt(0)));
                        int endIndex = startIndex + substring.length() - 1;
                        revealedMessage.delete(startIndex, endIndex + 1);

                        substring.reverse();
                        revealedMessage.append(substring);
                    } else {
                        System.out.println("error");
                        command = scan.nextLine();
                        continue;
                    }
                    break;
                case "ChangeAll":
                    String occurrence = tokens[1];
                    String replacement = tokens[2];
                    String replacedString = revealedMessage.toString().replaceAll(occurrence, replacement);

                    revealedMessage.setLength(0);
                    revealedMessage.append(replacedString);
                    break;
            }
            System.out.println(revealedMessage);
            command = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s", revealedMessage);
    }
}
