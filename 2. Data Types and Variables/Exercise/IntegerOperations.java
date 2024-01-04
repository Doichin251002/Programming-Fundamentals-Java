import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        int thirdNum = Integer.parseInt(scan.nextLine());
        int fourthNum = Integer.parseInt(scan.nextLine());

        int sum = firstNum + secondNum;
        int division = sum / thirdNum;
        int res = division * fourthNum;

        System.out.println(res);
    }
}