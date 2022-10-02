import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> price = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Double::parseDouble).collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Prices with VAT:");
        UnaryOperator<Double> addVAT = p -> p * 1.2;
        price.forEach(x -> System.out.printf("%.2f%n", addVAT.apply(x)));
    }
}
