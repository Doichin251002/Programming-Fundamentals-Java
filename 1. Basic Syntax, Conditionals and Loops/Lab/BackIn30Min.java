import java.util.Scanner;

public class BackIn30Min {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int allMin = hours * 60 + minutes + 30;

        hours = allMin / 60;
        minutes = allMin % 60;

        if (hours > 23) hours = 0;

        System.out.printf("%d:%02d" , hours, minutes);
    }
}