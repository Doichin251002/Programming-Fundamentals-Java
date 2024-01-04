import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        double grade = Double.parseDouble(scan.nextLine());

        String result = String.format("Name: %s, Age: %d, Grade: %.2f", name, age, grade);

        System.out.println(result);
    }
}