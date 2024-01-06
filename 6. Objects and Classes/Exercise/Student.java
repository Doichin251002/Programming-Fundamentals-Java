import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }
    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f",this.firstName, this.lastName, this.grade);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countStudents = Integer.parseInt(scan.nextLine());

        List<Student> listStudents = new ArrayList<>();
        for (int i = 1; i <= countStudents; i++) {
            String [] currentStudent = scan.nextLine().split(" ");
            String firstName = currentStudent[0];
            String lastName = currentStudent[1];
            double grade = Double.parseDouble(currentStudent[2]);

            Student student = new Student(firstName, lastName, grade);
            listStudents.add(student);
        }
        listStudents.sort(Comparator.comparing(Student::getGrade).reversed());

        for (Student element : listStudents) {
            System.out.println(element);
        }
    }
}
