import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(?<chars>[^0-9]+)(?<digits>[0-9]+)";
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String chars = matcher.group("chars").toUpperCase(Locale.ROOT);
            int digits = Integer.parseInt(matcher.group("digits"));

            //sb.append(chars.repeat(Math.max(0, digits)));
            for (int i = 0; i < digits; i++) {
                sb.append(chars);
            }
        }
//        String message = sb.toString();
//
//
//        String[] chars = message.split("");
//        Set<String> uniqueSymbols = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
//        Collections.addAll(uniqueSymbols, chars);

        System.out.printf("Unique symbols used: %d%n", sb.chars().distinct().count());
        System.out.println(sb);

    }
}
