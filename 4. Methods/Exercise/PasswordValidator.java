import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String passwordInput = scan.nextLine();

        boolean is6to10Chars = rule6to10chars(passwordInput);
        boolean isLetterOrDigit = ruleOnlyLettersAndDigits(passwordInput.toLowerCase());
        boolean are2Digits = rule2Digits(passwordInput);

        if (!is6to10Chars) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isLetterOrDigit) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!are2Digits) {
            System.out.println("Password must have at least 2 digits");
        }
        else {
            System.out.println("Password is valid");
        }
    }

    public static boolean rule6to10chars(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }
        return false;
    }

    public static boolean ruleOnlyLettersAndDigits(String password) {
        boolean isLetterOrDigit = false;
        for (char currentSymbol : password.toCharArray())
            if ((currentSymbol >= 48 && currentSymbol <= 57) //проверка дали е число
                    || (currentSymbol >= 97 && currentSymbol <= 122)) { //проверка дали е буква
                isLetterOrDigit = true;
            }
            else { //проверка дали е специален знак
                isLetterOrDigit = false;
                break;
            }
        return isLetterOrDigit;
    }

    public static boolean rule2Digits(String password) {
        char[] currentSymbol = new char[password.length()];
        for (int i = 0; i < password.length() - 1; i++) {
            currentSymbol[i] = password.charAt(i);
            currentSymbol[i + 1] = password.charAt(i + 1);
            if ((currentSymbol[i] >= 48 && currentSymbol[i] <= 57) //проверка дали сегашния и следващия символ са числа
                    && (currentSymbol[i + 1] >= 48 && currentSymbol[i + 1] <= 57)) {
                return true;
            }
        }
        return false;
    }
}
