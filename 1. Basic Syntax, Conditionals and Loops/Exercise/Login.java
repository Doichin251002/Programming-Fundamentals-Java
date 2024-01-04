import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = "";

        for (int position = username.length() - 1; position >= 0; position--) {
            char currSymbol = username.charAt(position);
            password += currSymbol;
        }

        String entryPass = scan.nextLine();
        int countTry = 0;
        boolean isValid = true;

        while (!entryPass.equals(password)) {
            countTry++;
            if (countTry == 4) {
                isValid = false;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            entryPass = scan.nextLine();
        }

        if (isValid) System.out.printf("User %s logged in.", username);
        else System.out.printf("User %s blocked!", username);
    }
}