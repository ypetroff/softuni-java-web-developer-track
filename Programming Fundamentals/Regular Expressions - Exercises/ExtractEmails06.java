import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "[\\w\\-.]+@([\\w\\-]+\\.)+[\\w\\-]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            if(matcher.group().charAt(0) != '-' && matcher.group().charAt(0) != '.' && matcher.group().charAt(0) != '_') {
                System.out.println(matcher.group());
            }
        }
    }
}
