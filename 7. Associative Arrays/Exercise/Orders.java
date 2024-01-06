import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        LinkedHashMap<String, List<Double>> productDataMap = new LinkedHashMap<>();
        while (!command.equals("buy")) {
            String [] inputData = command.split(" ");
            String product = inputData[0];
            double price = Double.parseDouble(inputData[1]);
            int quantity = Integer.parseInt(inputData[2]);

            if (productDataMap.containsKey(product)) {
                quantity += productDataMap.get(product).get(1);

                productDataMap.get(product).set(0, price);
                productDataMap.get(product).set(1, (double)quantity);
            }
            else {
                productDataMap.putIfAbsent(product, new ArrayList<>());
                productDataMap.get(product).add(price);
                productDataMap.get(product).add((double) quantity);
            }
            command = scan.nextLine();
        }

        LinkedHashMap<String, Double> orderMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : productDataMap.entrySet()) {
            double totalPrice = entry.getValue().get(0) * entry.getValue().get(1);
            orderMap.put(entry.getKey(), totalPrice);
        }
        orderMap.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value));
    }
}
