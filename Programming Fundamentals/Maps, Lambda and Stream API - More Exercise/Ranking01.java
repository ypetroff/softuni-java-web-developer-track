import java.util.*;

public class Ranking01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String contestInput = scanner.nextLine();
        Map<String, String> contestPasswords = new LinkedHashMap<>();

        while (!contestInput.equals("end of contests")) {

            String[] newData = contestInput.split(":");
            String contest = newData[0];
            String password = newData[1];

            contestPasswords.putIfAbsent(contest, password);
            contestInput = scanner.nextLine();
        }
        String submissions = scanner.nextLine();
        Map<String, Map<String, Integer>> candidates = new TreeMap<>();
        while (!submissions.equals("end of submissions")) {
            String[] newData = submissions.split("=>");
            String contest = newData[0];
            String password = newData[1];
            String username = newData[2];
            int points = Integer.parseInt(newData[3]);


            if (contestPasswords.containsKey(contest) && contestPasswords.get(contest).equals(password)) {

                candidates.putIfAbsent(username, new LinkedHashMap<>());
                candidates.get(username).putIfAbsent(contest, 0);
                if (candidates.get(username).get(contest) < points) {
                  candidates.get(username).put(contest, points);
                }
                }
            submissions = scanner.nextLine();
            }
        String bestCandidate = "";
        int bestPoints = 0;

        for (Map.Entry<String, Map<String, Integer>> entry : candidates.entrySet()) {
            int currentSum = 0;
            for (Map.Entry<String ,Integer> integerEntry : entry.getValue().entrySet()) {
                currentSum += integerEntry.getValue();
            }
            if(currentSum > bestPoints) {
                bestPoints = currentSum;
                bestCandidate = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestPoints);
        System.out.println("Ranking: ");
        candidates.forEach((k, v) -> {
            System.out.printf("%s%n", k);
            v.entrySet().stream().sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                    .forEach(element -> System.out.printf("#  %s -> %d%n", element.getKey(), element.getValue()));
        });

        }
    }

