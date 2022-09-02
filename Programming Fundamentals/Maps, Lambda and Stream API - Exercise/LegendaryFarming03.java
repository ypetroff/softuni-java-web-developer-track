import java.util.*;


public class LegendaryFarming03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> collectedMaterials = new HashMap<>();

        String keyWord;
        loop:
        while (true) {
            String[] materials = input.toLowerCase(Locale.ROOT).trim()
                    .split("\\s+");

            for (int i = 0; i < materials.length; i += 2) {
                int quantity = Integer.parseInt(materials[i]);
                String material = materials[i + 1];
                collectedMaterials.putIfAbsent(material, 0);
                collectedMaterials.put(material, collectedMaterials.get(material) + quantity);

                    if ((material.equals("shards") || material.equals("fragments")  ||
                           material.equals("motes")) && collectedMaterials.get(material) >= 250) {
                        collectedMaterials.put(material, collectedMaterials.get(material) - 250);
                        keyWord = material;
                        break loop;
                    }
            }
            input = scanner.nextLine();
        }

        if (keyWord.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (keyWord.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        } else {
            System.out.println("Dragonwrath obtained!");
        }
        collectedMaterials.putIfAbsent("fragments", 0);
        collectedMaterials.putIfAbsent("shards", 0);
        collectedMaterials.putIfAbsent("motes", 0);

        collectedMaterials.entrySet().stream()
                .filter(e -> e.getKey().equalsIgnoreCase("Shards") ||
                        e.getKey().equalsIgnoreCase("Fragments") ||
                        e.getKey().equalsIgnoreCase("Motes"))
                .sorted((e1, e2) -> {
                    int res = e2.getValue().compareTo(e1.getValue());
                    if (res == 0) {
                        res = e1.getKey().compareTo(e2.getKey());
                    }
                    return res;
                })
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue())
                );

        collectedMaterials.entrySet().stream()
                .filter(e -> !e.getKey().equalsIgnoreCase("Shards") &&
                        !e.getKey().equalsIgnoreCase("Fragments") &&
                        !e.getKey().equalsIgnoreCase("Motes"))
                .sorted(Map.Entry.comparingByKey())
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
    }
}

