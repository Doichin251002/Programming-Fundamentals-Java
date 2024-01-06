import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student2 {
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

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
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

            if (isStudentFound(studentList, firstName, lastName)) {
                Student foundStudent = getStudent(studentList, firstName, lastName);

                foundStudent.setFirstName(firstName);
                foundStudent.setLastName(lastName);
                foundStudent.setAge(age);
                foundStudent.setTown(town);

            }
            else {
                Student currentStudent = new Student(firstName, lastName, age, town);
                studentList.add(currentStudent);
            }
            command = scan.nextLine();
        }

        String homeTown = scan.nextLine();
        for (Student element : studentList) {
            if (element.getTown().equals(homeTown)) {
                System.out.printf("%s %s is %d years old%n", element.getFirstName(), element.getLastName(), element.getAge());
            }
        }
    }

    private static Student getStudent(List<Student> studentList, String firstName, String lastName) {
        Student foundStudent = null;

        for (Student element : studentList) {
            if (element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)) {
                foundStudent = element;
            }
        }
        return foundStudent;
    }

    public static boolean isStudentFound (List<Student> studentList, String firstName, String lastName) {
        for (Student element : studentList) {
            if (element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}
