import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputKey = scan.nextLine();
        String command = scan.nextLine();

        StringBuilder sb = new StringBuilder(inputKey);
        while (!command.equals("Generate")) {
            String [] tokens = command.split(">{3}");
            String operation = tokens[0];
            String subString;
            int startIndex;
            int endIndex;
            int validStartIndex;
            int validEndIndex;

            switch (operation) {
                case "Contains":
                    subString = tokens[1];
                    if (sb.toString().contains(subString)) {
                       System.out.printf("%s contains %s%n", sb, subString);
                    }
                    else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String typeCase = tokens[1];
                    startIndex = Integer.parseInt(tokens[2]);
                    endIndex = Integer.parseInt(tokens[3]);

                    validStartIndex = Math.min(startIndex, endIndex);
                    validEndIndex = Math.max(startIndex, endIndex);

                    if (typeCase.equals("Upper")) {
                        subString = sb.substring(validStartIndex, validEndIndex).toUpperCase();
                    }
                    else {
                        subString = sb.substring(validStartIndex, validEndIndex).toLowerCase();
                    }
                    System.out.println(sb.replace(validStartIndex, validEndIndex, subString));
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);

                    validStartIndex = Math.min(startIndex, endIndex);
                    validEndIndex = Math.max(startIndex, endIndex);

                    System.out.println(sb.replace(validStartIndex, validEndIndex, ""));
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println("Your activation key is: " + sb);
    }
}