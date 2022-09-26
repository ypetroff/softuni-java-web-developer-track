import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> concertsData = new LinkedHashMap<>();
        String regex = "(?<singer>[A-Za-z ]+)(?<separator> )@(?<venue>[A-Za-z ]+)\\k<separator>(?<price>[\\d]+)\\k<separator>(?<count>[\\d]+)";
        Pattern pattern = Pattern.compile(regex);

        String command;
        while (!"End".equals(command = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(command);
            if(matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketPrice = Integer.parseInt(matcher.group("price"));
                int ticketCount = Integer.parseInt(matcher.group("count"));
                int collectedMoney = ticketCount * ticketPrice;

                concertsData.putIfAbsent(venue, new LinkedHashMap<>());
                concertsData.get(venue).putIfAbsent(singer, 0);
                concertsData.get(venue).put(singer,  concertsData.get(venue).get(singer) + collectedMoney);
            }

        }
        concertsData.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });
    }
}
