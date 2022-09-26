import java.util.*;

public class PopulationCounter10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> worldData = new LinkedHashMap<>();

        String command;
        while (!"report".equals(command = scanner.nextLine())) {
            String[] data = command.split("\\|");
            String city = data[0];
            String state = data[1];
            int population = Integer.parseInt(data[2]);

            worldData.putIfAbsent(state, new LinkedHashMap<>());
            worldData.get(state).put(city, population);
        }

        worldData.entrySet().stream()
                .sorted((s1,s2) -> Long.compare(s2.getValue().values().stream().mapToLong(i -> i).sum(),
                        s1.getValue().values().stream().mapToLong(i -> i).sum()))
                .forEach(x -> {
                    System.out.printf("%s (total population: %d)%n", x.getKey(),
                            x.getValue().values().stream().mapToLong(i -> i).sum());
                   x.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                   .forEach(e ->  System.out.printf("=>%s: %d%n", e.getKey(), e.getValue()));
                });
    }
}
