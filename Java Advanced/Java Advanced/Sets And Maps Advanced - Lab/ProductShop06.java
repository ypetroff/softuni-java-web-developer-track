import java.util.*;

public class ProductShop06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopInventory = new TreeMap<>();

        String command;
        while(!"Revision".equalsIgnoreCase(command=scanner.nextLine())) {
            String[] shopInfo = command.split(",\\s+");
            String name = shopInfo[0];
            String product = shopInfo[1];
            double price = Double.parseDouble(shopInfo[2]);

            shopInventory.putIfAbsent(name, new LinkedHashMap<>());
            shopInventory.get(name).putIfAbsent(product, 0.0);
            shopInventory.get(name).put(product,  shopInventory.get(name).get(product) + price);
        }

        shopInventory.forEach((key, value) -> {
            System.out.printf("%s->%n", key);
            value.forEach((k, v) -> System.out.printf("Product: %s, Price: %.1f%n", k, v));
        });
    }
}
