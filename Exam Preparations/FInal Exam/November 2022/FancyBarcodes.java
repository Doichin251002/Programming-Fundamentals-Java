import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Pattern pattern = Pattern.compile("^@#+(?=[A-Z])(?<barcode>[A-Za-z0-9]{6,})(?<=[A-Z])@#+$");
        Matcher matcher = null;
        for (int i = 0; i < count; i++) {
            String barcode = scan.nextLine();

            matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                String substring = matcher.group("barcode");
                StringBuilder sbDigits = new StringBuilder();
                for (char symbol : substring.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        sbDigits.append(symbol);
                    }
                }

                if (sbDigits.length() > 0) {
                    System.out.println("Product group: " + sbDigits);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
