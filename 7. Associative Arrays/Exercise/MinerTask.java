import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        LinkedHashMap<String, Integer> treasuresMap = new LinkedHashMap<>();
        String resource = "";
        int quantity;
        int currentLine = 0;
        while (!command.equals("stop")) {
            currentLine++;
            if (currentLine % 2 != 0) {
                resource = command;
                treasuresMap.putIfAbsent(resource, 0);
            }
            else {
                quantity = Integer.parseInt(command);
                treasuresMap.put(resource, treasuresMap.get(resource) + quantity);
            }
            command = scan.nextLine();
        }

        for (Map.Entry<String, Integer> entry : treasuresMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
