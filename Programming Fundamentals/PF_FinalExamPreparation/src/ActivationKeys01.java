import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
//        String rawActivationKey = scanner.nextLine();
//        String regex = "[A-Za-z0-9]+";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(rawActivationKey);
//
//        StringBuilder sb = new StringBuilder();
//        while (matcher.find()) {
//            sb.append(matcher.group());
//        }

        String command;
        while (!"Generate".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] tokens = command.split(">>>");
            switch (tokens[0]) {
                case "Contains":
                    if (sb.toString().contains(tokens[1])) {
                        System.out.printf("%s contains %s%n", sb, tokens[1]);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    if (tokens[1].equals("Upper")) {
                        String start = sb.substring(0, Integer.parseInt(tokens[2]));
                        String modified = sb.substring(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])).toUpperCase(Locale.ROOT);
                        String end = sb.substring(Integer.parseInt(tokens[3]));
                        sb.setLength(0);
                        sb.append(start);
                        sb.append(modified);
                        sb.append(end);
                    } else if (tokens[1].equals("Lower")) {
                        String start = sb.substring(0, Integer.parseInt(tokens[2]));
                        String modified = sb.substring(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])).toLowerCase(Locale.ROOT);
                        String end = sb.substring(Integer.parseInt(tokens[3]));
                        sb.setLength(0);
                        sb.append(start);
                        sb.append(modified);
                        sb.append(end);
                    }
                    System.out.println(sb);
                    break;
                case "Slice":
                    sb.delete(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    System.out.println(sb);
                    break;
            }
        }
        System.out.printf("Your activation key is: %s", sb);
    }
}
