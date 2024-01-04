import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] numbersArr = scan.nextLine().split(" ");
        int rotations = Integer.parseInt(scan.nextLine());

        for (int rotation = 1; rotation <= rotations; rotation++) {
            String firstElement = numbersArr[0];
            for (int i = 0; i < numbersArr.length - 1; i++) {
                numbersArr[i] = numbersArr[i + 1];
            }
            numbersArr[numbersArr.length - 1] = firstElement;
        }
        System.out.println(String.join(" ", numbersArr));
    }
}
