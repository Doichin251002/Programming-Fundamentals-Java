import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wagons = Integer.parseInt(scan.nextLine());

        int[] passengersArr = new int[wagons];
        int totalPeople = 0;

        for (int i = 0; i < wagons; i++) {
            passengersArr[i] = Integer.parseInt(scan.nextLine());
            System.out.print(passengersArr[i] + " ");
            totalPeople += passengersArr[i];
        }
        System.out.printf("%n%d", totalPeople);
    }
}