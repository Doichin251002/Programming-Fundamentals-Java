import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> phoneList = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("End")) {
            String [] manipulation = command.split(" - ");
            String operation = manipulation[0];
            String modelPhone = manipulation[1];

            switch (operation) {
                case "Add":
                    if (!phoneList.contains(modelPhone)) {
                        phoneList.add(modelPhone);
                    }
                    break;
                case "Remove":
                    phoneList.remove(modelPhone);
                    break;
                case "Bonus phone":
                    String oldPhone = modelPhone.split(":")[0];
                    String newPhone = modelPhone.split(":")[1];

                    if (phoneList.contains(oldPhone)) {
                        int indexOfNewPhone = phoneList.indexOf(oldPhone) + 1;
                        phoneList.add(indexOfNewPhone, newPhone);
                    }
                    break;
                case "Last":
                    if (phoneList.contains(modelPhone)) {
                        phoneList.add(modelPhone);
                        phoneList.remove(modelPhone);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(phoneList.toString().replaceAll("[\\[\\]]", ""));
    }
}
