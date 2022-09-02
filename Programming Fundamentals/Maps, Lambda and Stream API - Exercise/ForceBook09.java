import java.util.*;

public class ForceBook09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Map<String, List<String>> forceTeams = new TreeMap<>();

        while (!"Lumpawaroo".equals(input = scanner.nextLine())) {


            if (input.contains("|")) {
                String[] userData = input.split("\\s+\\|\\s+");
                String force = userData[0];
                String name = userData[1];

                boolean check = forceTeams.entrySet().stream().anyMatch(current -> current.getValue().contains(name));

                if(!check) {
                    forceTeams.putIfAbsent(force, new ArrayList<>());
                    forceTeams.get(force).add(name);
                }


            } else {
                String[] userData = input.split("\\s+->\\s+");
                String force = userData[1];
                String name = userData[0];

                forceTeams.entrySet().stream().filter(current -> current.getValue().contains(name))
                        .findFirst().ifPresent(current -> forceTeams.get(current.getKey()).remove(name));
                forceTeams.putIfAbsent(force, new ArrayList<>());
                forceTeams.get(force).add(name);
                System.out.printf("%s joins the %s side!%n", name, force);
            }
        }

        forceTeams.entrySet().stream()
                        .filter(x -> x.getValue().size() > 0)
                        .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                        .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().stream().sorted(String::compareTo)
                            .forEach(p -> System.out.printf("! %s%n", p));
                });
    }

}

