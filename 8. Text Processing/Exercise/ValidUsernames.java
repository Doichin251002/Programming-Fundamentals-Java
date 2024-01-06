import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] usernameArr = scan.nextLine().split(", ");

        for (String username : usernameArr) {
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }
    public static boolean isValidUsername(String username) {
        boolean isValid = false;
        if (username.length() >= 3 && username.length() <= 16) {
            for (char symbol : username.toCharArray()) {
                if (Character.isLetterOrDigit(symbol)) {
                    isValid = true;
                }
                else if ((symbol == '-') || (symbol == '–') || (symbol == '_')) {
                    isValid = true;
                }
                else {
                    return false;
                }
            }
        }
        return isValid;
    }
}