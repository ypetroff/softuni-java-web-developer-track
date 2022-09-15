import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race02 {
    public static int counter = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] participants = scanner.nextLine().split(",\\s");
        Map<String, Integer> standing = new LinkedHashMap<>();
        String regex = "[^_\\W]";
        Pattern pattern = Pattern.compile(regex);
        String command;

        for (String participant : participants) {
            standing.putIfAbsent(participant, 0);
        }


        while (!"end of race".equals(command = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(command);
            StringBuilder sb = new StringBuilder();

            while (matcher.find()) {
                sb.append(matcher.group());
            }
            StringBuilder name = new StringBuilder();
            int distance = 0;
            for (int i = 0; i < sb.length(); i++) {
                if(Character.isDigit(sb.toString().charAt(i))) {
                   distance += Character.getNumericValue(sb.toString().charAt(i)) ;
                } else {
                    name.append(sb.toString().charAt(i));
                }
            }
            if(standing.containsKey(name.toString())) {
                standing.put(name.toString(), standing.get(name.toString()) + distance);
            }

        }

        standing.entrySet().stream().sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue())).limit(3)
                .forEach(e -> {
                    if(counter == 1) {
                        System.out.printf("%dst place: %s%n", counter, e.getKey());
                    }else if (counter == 2) {
                        System.out.printf("%dnd place: %s%n", counter, e.getKey());
                    }else if (counter == 3) {
                        System.out.printf("%drd place: %s%n", counter, e.getKey());
                    }
                    counter++;
                });
    }
}
