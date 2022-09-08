import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Judge02 {

    public static int counter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        // Map<String, Map<String, Integer>> userData = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("no more time")) {

            String[] newData = input.split(" -> ");
            String username = newData[0];
            String contest = newData[1];
            int points = Integer.parseInt(newData[2]);

            contests.putIfAbsent(contest, new TreeMap<>());
            contests.get(contest).putIfAbsent(username, 0);

            if (contests.get(contest).get(username) < points) {
                contests.get(contest).put(username, points);
            }
            input = scanner.nextLine();
        }

        contests.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());


            value.entrySet().stream().sorted((val1, val2) -> val2.getValue().compareTo(val1.getValue()))
                    .forEach(p -> {
                        System.out.printf("%d. %s <::> %d%n", counter, p.getKey(), p.getValue());
                        counter++;
                    });
            counter = 1;
        });


        Map<String, Integer> userData = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : contests.entrySet()) {

            for (Map.Entry<String, Integer> val : entry.getValue().entrySet()) {
                userData.putIfAbsent(val.getKey(), 0);
                userData.put(val.getKey(), userData.get(val.getKey()) + val.getValue());

            }
        }

        System.out.println("Individual standings:");
        userData.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<String, Integer>comparingByKey()))
                .forEach(e -> {
                    System.out.printf("%d. %s -> %d%n", counter, e.getKey(), e.getValue());
                    counter++;
                });
    }
}
