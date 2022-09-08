import java.util.*;

public class DragonArmy05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Map<String, List<Double>>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] dragonInfo = scanner.nextLine().split(" ");

            String type = dragonInfo[0];
            String name = dragonInfo[1];
            int damage;
            if (dragonInfo[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(dragonInfo[2]);
            }
            int health;
            if (dragonInfo[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(dragonInfo[3]);
            }
            int armor;
            if (dragonInfo[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(dragonInfo[4]);
            }

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, new ArrayList<>() {{
                add(0, (double)damage);
                add(1, (double)health);
                add(2, (double)armor);
            }});
        }
        dragons.forEach((key, value) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",key,
                    value.values().stream().map(doubles -> doubles.get(0)).mapToDouble(Double::doubleValue).average().orElseThrow(),
                    value.values().stream().map(doubles -> doubles.get(1)).mapToDouble(Double::doubleValue).average().orElseThrow(),
                    value.values().stream().map(doubles -> doubles.get(2)).mapToDouble(Double::doubleValue).average().orElseThrow());

            value.forEach((k, v) -> System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", k, v.get(0), v.get(1), v.get(2)));
        });
    }

}
