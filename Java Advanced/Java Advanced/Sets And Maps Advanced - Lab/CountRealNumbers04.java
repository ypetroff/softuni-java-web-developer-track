import java.util.*;


public class CountRealNumbers04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> realNumbers = new LinkedHashMap<>();
        for (double number : input) {
            realNumbers.putIfAbsent(number, 0);
            realNumbers.put(number, realNumbers.get(number) + 1);
        }
        realNumbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
