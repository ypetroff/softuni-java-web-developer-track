import java.util.*;

public class PlantDiscovery03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsRarity = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPlants; i++) {
            String[] plantDetails = scanner.nextLine().split("<->");
            String plantName = plantDetails[0];
            int plantRarity = Integer.parseInt(plantDetails[1]);
            plantsRarity.put(plantName, plantRarity);
        }

        Map<String, List<Double>> plantsRating = new LinkedHashMap<>();
        for (String plant : plantsRarity.keySet()) {
            plantsRating.put(plant, new ArrayList<>());
        }
        String command;
        while (!"Exhibition".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] tokens = command.split(": ");


            switch (tokens[0]) {
                case "Rate":
                    ratePlant(tokens[1], plantsRating);
                    break;
                case "Update":
                    updateRarity(tokens[1], plantsRarity);
                    break;
                case "Reset":
                    resetRating(tokens[1], plantsRating, plantsRarity);
                    break;
            }
        }
        Map<String, List<Double>> allStats = new LinkedHashMap<>();
        plantsRarity.forEach((key, value) -> {
            allStats.put(key, new ArrayList<>());
            allStats.get(key).add((double) value);
        });

        plantsRating.forEach((key, value) -> {
            double size = value.size();
            double total = value.stream().reduce(0.0, Double::sum); //(a, b) -> a + b
            double average = total / size;
            if(Double.isNaN(average)) {
                average = 0;
            }
            allStats.get(key).add(average);
        });

        //0 rarity, 1 rating
        System.out.println("Plants for the exhibition:");

        allStats.entrySet().stream().sorted((p1, p2) -> {
                    int result = p2.getValue().get(0).compareTo(p1.getValue().get(0));
                    if (result == 0) {
                        result = p2.getValue().get(1).compareTo(p1.getValue().get(1));
                    }
                    return result;
                })
                .forEach(plant ->
                        System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", plant.getKey(), plant.getValue().get(0), plant.getValue().get(1)));
    }

    private static void ratePlant(String token, Map<String, List<Double>> plantsRating) {
        String[] plantDetails = token.split(" - ");
        String plantName = plantDetails[0];
        double plantRating = Double.parseDouble(plantDetails[1]);

        if(plantsRating.containsKey(plantName)) {
            plantsRating.get(plantName).add(plantRating);
        } else {
            System.out.println("error");
        }

    }

    private static void updateRarity(String token, Map<String, Integer> plantsRarity) {
        String[] plantDetails = token.split(" - ");
        String plantName = plantDetails[0];
        int plantRarity = Integer.parseInt(plantDetails[1]);
        if(plantsRarity.containsKey(plantName)) {
            plantsRarity.put(plantName, plantRarity);
        } else {
            System.out.println("error");
        }
    }

    private static void resetRating(String plantName, Map<String, List<Double>> plantsRating, Map<String, Integer> plantsRarity) {
        if (plantsRarity.containsKey(plantName) || plantsRating.containsKey(plantName)) {
            plantsRating.put(plantName, new ArrayList<>());
        } else {
            System.out.println("error");
        }
    }
}
