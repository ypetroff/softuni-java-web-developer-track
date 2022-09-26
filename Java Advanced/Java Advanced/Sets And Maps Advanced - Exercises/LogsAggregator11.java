import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userData = new TreeMap<>();

       int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String ip = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);
            userData.putIfAbsent(user, new TreeMap<>());
            userData.get(user).putIfAbsent(ip, 0);
            userData.get(user).put(ip, userData.get(user).get(ip) + duration);
        }

        userData.forEach((key, value) ->
                System.out.printf("%s: %d %s%n",
                        key, value.values().stream().mapToInt(i -> i).sum(), Arrays.toString(value.keySet().toArray()/*or String.join(", ", value.keySet()*/)));

    }
}
