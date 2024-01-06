import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    static class Person {
        private String name;
        private String ID;
        private int age;

        public Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public int getAge() {
            return age;
        }
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.ID, this.age);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        List<Person> listPerson = new ArrayList<>();
        while (!command.equals("End")) {
            String [] personInfo = command.split(" ");
            String name = personInfo[0];
            String ID = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);

            Person person = new Person(name, ID, age);
            listPerson.add(person);

            command = scan.nextLine();
        }

        listPerson.sort(Comparator.comparing(Person::getAge));
        for (Person element : listPerson) {
            System.out.println(element);
        }
    }
}
