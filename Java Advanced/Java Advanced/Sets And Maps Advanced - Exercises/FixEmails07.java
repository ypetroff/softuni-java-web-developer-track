import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FixEmails07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> map = new LinkedHashMap<>();
        String command, prev = "";
        int counter = 1;
        while (!"stop".equalsIgnoreCase(command = scanner.nextLine())) {
            if (counter % 2 != 0) {
                map.putIfAbsent(command, "");
                prev = command;
            } else {
                if (valid(command)) {
                    map.put(prev, command);
                }
            }
            counter++;
        }

        map.entrySet().stream().filter(x -> !x.getValue().equals(""))
                .forEach(x -> System.out.printf("%s -> %s%n", x.getKey(), x.getValue()));
    }

    private static boolean valid(String command) {
        String regex = "\\.(?<suffix>com|us|uk)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        return !matcher.find();
    }
}
