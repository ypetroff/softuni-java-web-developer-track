import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputs = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("\\|(?<boss>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+ [A-Za-z]+)#");

        for (int i = 0; i < inputs; i++) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            if(matcher.find()) {
             //   while (matcher.find()) {
                    String boss = matcher.group("boss");
                    String title = matcher.group("title");

                    System.out.printf("%s, The %s%n", boss, title);
                    System.out.printf(">> Strength: %d%n", boss.length());
                    System.out.printf(">> Armor: %d%n", title.length());
          //      }
            } else {
                System.out.println("Access denied!");
            }

        }
    }
}
