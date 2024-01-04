import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String typeInput = scan.nextLine();
        switch (typeInput) {
            case "int":
                int firstNum = Integer.parseInt(scan.nextLine());
                int secondNum = Integer.parseInt(scan.nextLine());

                System.out.println(getMax(firstNum,secondNum));
                break;
            case "char":
                char firstSymbol = scan.nextLine().charAt(0);
                char secondSymbol = scan.nextLine().charAt(0);

                System.out.println(getMax(firstSymbol,secondSymbol));
                break;
            case "string":
                String firstText = scan.nextLine();
                String secondText = scan.nextLine();

                System.out.println(getMax(firstText, secondText));
                break;
        }

    }

    private static int getMax(int number1, int number2) {
        if (number1 > number2) {
            return number1;
        }
        else {
            return number2;
        }
    }
    private static char getMax(char symbol1, char symbol2) {
        if (symbol1 > symbol2) {
            return symbol1;
        }
        else {
            return symbol2;
        }
    }
    public static String getMax(String text1, String text2) {
        if (text1.compareTo(text2) > 0) {
            return text1;
        }
        else {
            return text2;
        }
    }
}
