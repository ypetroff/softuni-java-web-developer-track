import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int messagesCount = Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < messagesCount; i++) {
            char[] message = scanner.nextLine().toCharArray();
            int key = 0;
            for (char c : message) {
                if(c == 'S' || c== 's' || c== 'T' || c== 't' || c== 'A' || c== 'a' || c== 'R' || c== 'r') {
                    key++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : message) {
                c = (char)(c - key);
                sb.append(c);
            }
            String decryptedMessage = sb.toString();
            String regex = "[^@\\-!:>]*@(?<planet>[A-Z]*[a-z]*)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<typeAttack>[A|D])![^@\\-!:>]*->(?<soldiers>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);

            while (matcher.find()) {
                String planet = matcher.group("planet");
               // int population = Integer.parseInt(matcher.group("population"));
                char typeAttack = matcher.group("typeAttack").charAt(0);
            //   int soldiers = Integer.parseInt(matcher.group("soldiers"));

                if(typeAttack == 'A') {
                    attackedPlanets.add(planet);
                }else if(typeAttack == 'D') {
                    destroyedPlanets.add(planet);
                }
            }
        }

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        attackedPlanets.stream().sorted(String::compareTo)
                .forEach(p -> {
                    System.out.println("-> " + p);
                });
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        destroyedPlanets.stream().sorted(String::compareTo)
                .forEach(p -> {
                    System.out.println("-> " + p);
                });
    }
}
