import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().split("(\\s+)?,\\s*");
        String regexDamage = "[-|+]?\\d+\\.?\\d*";
        String regexHealth = "[^\\d\\-+*/.]";
        String regexOperation = "[/*]";
        Pattern patternDamage = Pattern.compile(regexDamage);
        Pattern patternHealth = Pattern.compile(regexHealth);
        Pattern patternOperation = Pattern.compile(regexOperation);
        Map<String, Map<Integer, Double>> demonBook = new TreeMap<>();
        int health = 0;
        double damage = 0;

        for (String demon : demons) {
            Matcher matcherDamage = patternDamage.matcher(demon);

            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group());
            }

            Matcher matcherHealth = patternHealth.matcher(demon);
            while (matcherHealth.find()) {
                health += matcherHealth.group().charAt(0);
            }

            Matcher matcherOperations = patternOperation.matcher(demon);
            while (matcherOperations.find()) {
                damage = matcherOperations.group().equals("*") ? damage * 2 : damage / 2;
            }
            demonBook.put(demon, new HashMap<>());
            demonBook.get(demon).put(health, damage);
            health =0;
            damage = 0;
        }
        demonBook.forEach((key, value) -> value.forEach((k, v) ->
                System.out.printf("%s - %d health, %.2f damage%n", key, k, v)));
    }
}
