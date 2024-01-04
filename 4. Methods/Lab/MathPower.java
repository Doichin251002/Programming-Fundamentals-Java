import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberInput = Double.parseDouble(scan.nextLine());
        double powerInput = Double.parseDouble(scan.nextLine());

        double poweredNumber = powerNumber(numberInput, powerInput);

        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(poweredNumber));
    }

    public static double powerNumber(double number, double power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }
}
