import java.util.*;

public class Orders04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;

        Map<String, double[]> order = new LinkedHashMap<>();


        while (!"buy".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] itemDetails = input.split("\\s+");
            String item = itemDetails[0];
            double price = Double.parseDouble(itemDetails[1]);
            double quantity = Double.parseDouble(itemDetails[2]);

            /* possible  two maps
            * Map item price
            * map item quantity
            * Then we change the value of the price and add the quantity*/

            order.putIfAbsent(item, new double[2]);
            order.put(item, changeValues(price, quantity, order.get(item)));

        }

        order.entrySet().forEach(x -> System.out.printf("%s -> %.2f%n", x.getKey(), returnProduct(x.getValue())));

    }



    private static double[] changeValues(double price, double quantity, double[] doubles) {
        return new double[]{price, doubles[1] + quantity};
    }

    private static double returnProduct(double[] value) {
        return value[0] * value[1];
    }

}
