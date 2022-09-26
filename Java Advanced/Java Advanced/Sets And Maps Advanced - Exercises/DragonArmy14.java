import java.util.*;

public class DragonArmy14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Again and again!
        Map<String, Map<String, List<Integer>>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] dragonData = scanner.nextLine().split("\\s+");
            String type = dragonData[0];
            String name = dragonData[1];
            int damage = dragonData[2].equals("null")
                    ? 45
                    : Integer.parseInt(dragonData[2]);
            int health = dragonData[3].equals("null")
            ? 250
            :Integer.parseInt(dragonData[3]);
            int armor = dragonData[4].equals("null")
            ? 10
            : Integer.parseInt(dragonData[4]);

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, Arrays.asList(damage, health, armor));
        }

        dragons.forEach((key, value) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, averageDamage(value), averageHealth(value), averageArmor(value));
            value.forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", k, v.get(0), v.get(1), v.get(2)));
        });
    }

    private static double averageDamage(Map<String, List<Integer>> value) {
        return value.values().stream().mapToDouble(i -> i.get(0)).average().orElse(0);
    }

    private static double averageHealth(Map<String, List<Integer>> value) {
        return value.values().stream().mapToDouble(i -> i.get(1)).average().orElse(0);
    }

    private static  double averageArmor(Map<String, List<Integer>> value) {

        return value.values().stream().mapToDouble(i -> i.get(2)).average().orElse(0);
    }
}
