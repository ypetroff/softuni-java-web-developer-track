import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coolnessRegex = "\\d";
        String input = scanner.nextLine();

        Pattern cool = Pattern.compile(coolnessRegex);
        Matcher matcherCool = cool.matcher(input);
        List<Integer> numbers = new ArrayList<>();
        while (matcherCool.find()) {
            numbers.add(Integer.parseInt(matcherCool.group()));
        }
        long coolness = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.printf("Cool threshold: %d%n", coolness);

        String emojiRegex = "(?<delimiter>[*:])\\k<delimiter>(?<emoji>[A-Z][a-z]{2,})\\k<delimiter>\\k<delimiter>";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher matcherEmoji = emojiPattern.matcher(input);
        List<String> coolEmojis = new ArrayList<>();
        int counter = 0;
        while (matcherEmoji.find()) {
            String emoji = matcherEmoji.group("emoji");
            char[] emojiArr = emoji.toCharArray();
            int emojiCoolness = 0;
            for (char c : emojiArr) {
                emojiCoolness += c;
            }
            if (emojiCoolness >= coolness) {
                coolEmojis.add(matcherEmoji.group());
            }
            counter++;
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);
        coolEmojis.forEach(System.out::println);
    }
}
