import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        int price = 0;
        boolean isValid = true;

        if (age > 0 && age <= 18) {
            switch (day) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
                default:
                    isValid = false;
            }
        } else if (age > 18 && age <= 64) {
            switch (day) {
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
                default:
                    isValid = false;
            }
        } else if (age > 64 && age <= 122) {
            switch (day) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
                default:
                    isValid = false;
            }
        }
        else isValid = false;

        if (!isValid) System.out.println("Error!");
        else System.out.printf("%d$", price);
    }
}