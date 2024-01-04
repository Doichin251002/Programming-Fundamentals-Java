import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] wordsArr1 = scan.nextLine().split(" ");
        String [] wordsArr2 = scan.nextLine().split(" ");

        for (String secondLine : wordsArr2) {
            for (String firstLine : wordsArr1) {
                if (secondLine.equals(firstLine)) {
                    System.out.print(firstLine + " ");
                    break;
                }
            }
        }
    }
}
