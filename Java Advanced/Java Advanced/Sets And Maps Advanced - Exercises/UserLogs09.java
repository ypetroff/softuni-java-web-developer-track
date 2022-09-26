import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs09 {
    private static int num = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> data = new TreeMap<>();

        String command;
        while (!"end".equals(command = scanner.nextLine())) {
            String[] components = command.split("\\s+");
            String ip = components[0].split("=")[1];
            String user = components[2].split("=")[1];

            data.putIfAbsent(user, new LinkedHashMap<>());
            data.get(user).putIfAbsent(ip, 0);
            data.get(user).put(ip, data.get(user).get(ip) + 1);
        }

        data.forEach((key, value) -> {
            System.out.println(key + ":");

//            int count = 1;
//            for (Map.Entry<String, Integer> entry : value.entrySet()) {
//                String output = String.format(count < value.entrySet().size()
//                        ? "%s => %d, " : "%s => %d.%n", entry.getKey(), entry.getValue());
//                System.out.printf("%s", output);
//                count++;
//            }
            value.forEach((key1, value1) -> {
                boolean isLast = false;
                System.out.printf("%s => %d", key1, value1);
                if (num < value.size()) {
                    System.out.print(", ");
                    num++;
                } else {
                    isLast = true;
                    System.out.print(".");
                }
                if (isLast) {
                    System.out.println();
                }
            });
        });
    }


}
