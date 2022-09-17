import java.util.*;

public class Pirates03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cities;
        Map<String, List<Integer>> toPlunder = new TreeMap<>();
        while(!"Sail".equals(cities = scanner.nextLine())) {
            String[] details = cities.split("\\|\\|");
            String city = details[0];
            int population = Integer.parseInt(details[1]);
            int gold = Integer.parseInt(details[2]);

            if (toPlunder.containsKey(city)) {
                population = population + toPlunder.get(city).get(0);
                gold = gold + toPlunder.get(city).get(1);
            }
            toPlunder.put(city, Arrays.asList(population, gold));
        }

        String events;
        while(!"End".equalsIgnoreCase(events = scanner.nextLine())) {
            String[] tokens = events.split("=>");
            String city = tokens[1];
            switch (tokens[0]) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(tokens[2]);
                    int goldStolen = Integer.parseInt(tokens[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, goldStolen,peopleKilled);
                    int populationLeft = toPlunder.get(city).get(0) - peopleKilled;
                    int goldLeft = toPlunder.get(city).get(1) - goldStolen;
                    toPlunder.put(city, Arrays.asList(populationLeft, goldLeft));
                    if(populationLeft == 0 || goldLeft == 0) {
                        System.out.printf("%s has been wiped off the map!%n", city);
                        toPlunder.remove(city);
                        if(toPlunder.size() == 0) {
                            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
                            break;
                        }


                    }
                    break;
                case "Prosper":
                    int goldAdded = Integer.parseInt(tokens[2]);
                    if (goldAdded < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }

                  int newAmount = goldAdded + toPlunder.get(city).get(1);
                    toPlunder.get(city).set(1, newAmount);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldAdded, city, newAmount);
                    break;
            }
        }

        if(toPlunder.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", toPlunder.size());
            toPlunder.entrySet().stream().sorted((c1, c2) -> c2.getValue().get(1).compareTo(c1.getValue().get(1)))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));
        }
    }
}
