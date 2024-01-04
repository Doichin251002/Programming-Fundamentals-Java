import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int persons = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());

        double courses = persons / (capacity * 1.0);

        System.out.printf("%.0f", Math.ceil(courses));
    }
}
