import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "([#|])(?<item>[A-Za-z ]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> items = new ArrayList<>();
        int sumCalories = 0;
        while (matcher.find()) {
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %s", matcher.group("item"), matcher.group("date"), matcher.group("calories")));
            sumCalories += Integer.parseInt(matcher.group("calories"));
        }

        System.out.printf("You have food to last you for: %d days!%n", sumCalories / 2000);
        items.forEach(System.out::println);
    }
}
