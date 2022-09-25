import java.util.*;

public class CitiesByContinentAndCountry07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> worldData = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String continent = data[0];
            String state = data[1];
            String city = data[2];

            worldData.putIfAbsent(continent, new LinkedHashMap<>());
            worldData.get(continent).putIfAbsent(state, new ArrayList<>());
            worldData.get(continent).get(state).add(city);
        }

        worldData.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            value.forEach((k, v) -> System.out.printf("%s -> %s%n", k, cities(v)));

        });
    }

    private static Object cities(List<String> strings) {
        return String.join(", ", strings);
    }
}
