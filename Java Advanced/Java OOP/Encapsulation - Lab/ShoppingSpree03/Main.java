package ShoppingSpree03;

import java.util.*;

public class Main {

    private static final Map<String, Person> people = new LinkedHashMap<>();
    private static final Map<String, Product> products = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        setObject(scanner, "Person");
        setObject(scanner, "Product");

        String command;
        while (!(command = scanner.nextLine()).equals("END")) {

            String[] tokens = command.split("\\s+");

            String namePerson = tokens[0];
            String nameProduct = tokens[1];

            try {
                people.get(namePerson).buyProduct(products.get(nameProduct));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        people.values().stream().map(Person::toString).forEach(System.out::println);
    }

    private static void setObject(Scanner scanner, String clazz) {
        String[] inputData = scanner.nextLine().split(";");
        Arrays.stream(inputData).map(s -> s.split("=")).forEach(data -> {
            var object = clazz.equals("Person")
                    ? people.put(data[0].trim(), new Person(data[0].trim(), Double.parseDouble(data[1].trim())))
                    : products.put(data[0].trim(), new Product(data[0].trim(), Double.parseDouble(data[1].trim())));
        });
    }
}
