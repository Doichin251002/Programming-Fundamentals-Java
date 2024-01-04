import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dayOfWeekArr = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        int numberDayOfWeek = Integer.parseInt(scan.nextLine());

        if (numberDayOfWeek >= 1 && numberDayOfWeek <= 7) {
            System.out.println(dayOfWeekArr[numberDayOfWeek - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}