import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] inputLine = scan.nextLine().split("\\s+");

        double sum = 0;
        for (String code : inputLine) {
            sum += getNumber(code);
        }

        System.out.printf("%.2f", sum);
    }

    public static double getNumber(String code) {
        double number = Double.parseDouble(code.substring(1, code.length() - 1));

        char leftSymbol = code.charAt(0);
        if (Character.isUpperCase(leftSymbol)) {
            int positionUpperCase = (int)leftSymbol - 64;
            number /= positionUpperCase;
        } else {
            int positionLowerCase = (int)leftSymbol - 96;
            number *= positionLowerCase;
        }

        char rightSymbol = code.charAt(code.length() - 1);
        if (Character.isUpperCase(rightSymbol)) {
            int positionUpperCase = (int)rightSymbol - 64;
            number -= positionUpperCase;
        } else {
            int positionLowerCase = (int)rightSymbol - 96;
            number += positionLowerCase;
        }
        return number;
    }
}
