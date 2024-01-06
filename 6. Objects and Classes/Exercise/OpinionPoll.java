import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> listPeople = new ArrayList<>();

        int lines = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= lines; i++) {
            String [] personalInfo = scan.nextLine().split(" ");
            String name = personalInfo[0];
            int age = Integer.parseInt(personalInfo[1]);

            Person person = new Person(name, age);

            if (age > 30) {
                listPeople.add(person);
            }
        }
        
        for (Person element : listPeople) {
            System.out.println(element.getName() + " - " + element.getAge());
        }
    }
}
