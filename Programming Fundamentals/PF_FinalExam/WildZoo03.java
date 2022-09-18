import java.util.*;

public class WildZoo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        Map<String, Integer> feedingAnimals = new TreeMap<>();
        Map<String, String> animalArea = new HashMap<>();
        Map<String, Integer> countAnimalsInArea = new TreeMap<>();
        while (!"EndDay".equals(command = scanner.nextLine())) {
            String[] initialCommand = command.split(": ");

            switch (initialCommand[0]) {
                case "Add":
                    String[] moreInfo = initialCommand[1].split("-");
                    String animalName = moreInfo[0];
                    int foodNeeded = Integer.parseInt(moreInfo[1]);
                    String area = moreInfo[2];
                    countAnimalsInArea.putIfAbsent(area, 0);
                    if(countAnimalsInArea.containsKey(area) && !feedingAnimals.containsKey(animalName)) {
                        countAnimalsInArea.put(area, countAnimalsInArea.get(area) + 1);
                    }
                    feedingAnimals.putIfAbsent(animalName, 0);
                    feedingAnimals.put(animalName, feedingAnimals.get(animalName) + foodNeeded);

                    animalArea.putIfAbsent(animalName, area);
                    break;
                case "Feed":
                    moreInfo = initialCommand[1].split("-");
                    animalName = moreInfo[0];
                    int foodReceived = Integer.parseInt(moreInfo[1]);

                    if (feedingAnimals.containsKey(animalName)) {
                        int necessaryFood = feedingAnimals.get(animalName) - foodReceived;
                        if (necessaryFood <= 0) {
                            countAnimalsInArea.put(animalArea.get(animalName), countAnimalsInArea.get(animalArea.get(animalName)) -1);
                            feedingAnimals.remove(animalName);
                            animalArea.remove(animalName);
                            System.out.printf("%s was successfully fed%n", animalName);
                        } else {
                            feedingAnimals.put(animalName, necessaryFood);
                        }
                    }
                    break;
            }
        }
        System.out.println("Animals:");
        feedingAnimals.entrySet().stream().sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue()))
                .forEach(animal -> System.out.printf("%s -> %dg%n", animal.getKey(), animal.getValue()));

        System.out.println("Areas with hungry animals:");
        countAnimalsInArea.entrySet().stream().sorted((c1,c2) -> c2.getValue().compareTo(c1.getValue()))
                .forEach(area -> {
                    if(area.getValue() > 0) {
                        System.out.printf("%s: %d%n", area.getKey(), area.getValue());
                    }
                });


    }
}
