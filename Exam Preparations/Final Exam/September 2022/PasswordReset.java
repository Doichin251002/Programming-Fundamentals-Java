import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rawPassword = scan.nextLine();
        String command = scan.nextLine();

        StringBuilder sbPassword = new StringBuilder(rawPassword);
        while (!command.equals("Done")) {
            String[] tokens = command.split(" ");
            String operation = tokens[0];
            String substring;
            int startIndex;
            int endIndex;
            switch (operation) {
                case "TakeOdd":
                    for (int i = 1; i <= sbPassword.length(); i++) {
                        sbPassword.deleteCharAt(i - 1);
                    }
                    System.out.println(sbPassword);
                    break;
                case "Cut":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]) + startIndex;
                    substring = sbPassword.substring(startIndex, endIndex);
                    if (sbPassword.toString().contains(substring)) {
                        sbPassword.delete(startIndex, endIndex);
                    }
                    System.out.println(sbPassword);
                    break;
                case "Substitute":
                    substring = tokens[1];
                    String substitute = tokens[2];

                    if (!sbPassword.toString().contains(substring)) {
                        System.out.println("Nothing to replace!");
                    } else {
                        while (sbPassword.toString().contains(substring)) {
                            startIndex = sbPassword.indexOf(substring);
                            endIndex = substring.length() + startIndex;
                            sbPassword.replace(startIndex, endIndex, substitute);
                        }
                        System.out.println(sbPassword);
                    }
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println("Your password is: " + sbPassword);
    }
}