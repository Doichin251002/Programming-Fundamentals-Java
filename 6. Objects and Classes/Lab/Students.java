import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String town;

        public Student (String firstName, String lastName, int age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }
        public String getTown() {
            return this.town;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        List<Student> studentList = new ArrayList<>();
        while (!command.equals("end")) {
            String [] inputStudentData = command.split(" ");

            String firstName = inputStudentData[0];
            String lastName = inputStudentData[1];
            int age = Integer.parseInt(inputStudentData[2]);
            String town = inputStudentData[3];

            Student currentStudent = new Student(firstName, lastName, age, town);

            studentList.add(currentStudent);

            command = scan.nextLine();
        }

        String homeTown = scan.nextLine();
        for (Student item : studentList) {
            if (item.getTown().equals(homeTown)) {
                System.out.printf("%s %s is %d years old%n", item.getFirstName(), item.getLastName(), item.getAge());
            }
        }
    }
}
