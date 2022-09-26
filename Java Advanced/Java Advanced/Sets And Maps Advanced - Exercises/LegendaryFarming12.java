import java.util.*;

public class LegendaryFarming12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Same as a problem from PF, different solution

        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        String collected;
        loop:
        while (true) {
            String[] material = scanner.nextLine().toLowerCase(Locale.ROOT).trim().split("\\s+");

            for (int i = 1; i < material.length; i += 2) {
                String item = material[i];

                if (item.equalsIgnoreCase("Shards") ||
                        item.equalsIgnoreCase("Fragments") ||
                        item.equalsIgnoreCase("motes")) {
                    keyMaterials.putIfAbsent(item, 0);
                    keyMaterials.put(item, keyMaterials.get(item) + Integer.parseInt(material[i - 1]));
                } else {
                    junk.putIfAbsent(item, 0);
                    junk.put(item, junk.get(item) + Integer.parseInt(material[i - 1]));
                }
                for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
                    if (entry.getValue() >= 250) {
                        collected = entry.getKey();
                        keyMaterials.put(entry.getKey(), entry.getValue() - 250);
                        break loop;
                    }
                }
            }

        }
        if (collected.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (collected.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        } else {
            System.out.println("Dragonwrath obtained!");
        }
        keyMaterials.putIfAbsent("fragments", 0);
        keyMaterials.putIfAbsent("shards", 0);
        keyMaterials.putIfAbsent("motes", 0);

        keyMaterials.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue()
                        .compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
        junk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
