import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        String command = scan.nextLine();
        while (!command.equals("Complete")) {
            String[] tokens = command.split(" ");
            String operation = tokens[0];
            int index;
            switch (operation) {
                case "Make":
                    String upLowCase = tokens[1];
                    index = Integer.parseInt(tokens[2]);
                    char symbol = password.charAt(index);

                    if (upLowCase.equals("Upper")) {
                       password = password.replace(symbol, Character.toUpperCase(symbol));
                    } else {
                        password = password.replace(symbol, Character.toLowerCase(symbol));
                    }
                    System.out.println(password);
                    break;
                case "Insert":
                    index = Integer.parseInt(tokens[1]);
                    symbol = tokens[2].charAt(0);

                    if (index >= 0 && index < password.length()) {
                        StringBuilder sb = new StringBuilder(password);
                        sb.insert(index, symbol);
                        password = sb.toString();
                        System.out.println(password);
                    }
                    break;
                case "Replace":
                    symbol = tokens[1].charAt(0);
                    int inputValue = Integer.parseInt(tokens[2]);
                    int symbolValue = symbol;

                    if (password.contains(symbol + "")) {
                        char replacement = (char)(inputValue + symbolValue);
                        password = password.replace(symbol + "", replacement + "");
                        System.out.println(password);
                    }
                    break;
                case "Validation":
                    if (password.length() < 8) {
                        System.out.println("Password must be at least 8 characters long!");
                    }
                    if (!isThereLetterOfDigit(password)) {
                        System.out.println("Password must consist only of letters, digits and _!");
                    }
                    if (!isThereUpperCaseLetters(password)) {
                        System.out.println("Password must consist at least one uppercase letter!");
                    }
                    if (!isThereLowerCaseLetters(password)) {
                        System.out.println("Password must consist at least one lowercase letter!");
                    }
                    if (!isThereDigit(password)) {
                        System.out.println("Password must consist at least one digit!");
                    }
                    break;
                default:
                    break;
            }
            command = scan.nextLine();
        }
    }

    public static boolean isThereLetterOfDigit(String text) {
        for (char currentLetter : text.toCharArray()) {
            if (!Character.isLetterOrDigit(currentLetter) && currentLetter != '_') {
                return false;
            }
        }
        return true;
    }
    public static boolean isThereUpperCaseLetters (String text) {
        for (char currentLetter : text.toCharArray()) {
            if (Character.isUpperCase(currentLetter)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isThereLowerCaseLetters (String text) {
        for (char currentLetter : text.toCharArray()) {
            if (Character.isLowerCase(currentLetter)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isThereDigit (String text) {
        for (char currentLetter : text.toCharArray()) {
            if (Character.isDigit(currentLetter)) {
                return true;
            }
        }
        return false;
    }
}