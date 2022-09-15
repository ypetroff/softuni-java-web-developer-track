import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        String regex = ">>(?<item>[A-Z]+[a-z]*)<<(?<price>\\d+\\.?\\d*)!(?<quantity>[\\d]+)\\b";
        Pattern pattern = Pattern.compile(regex);
        double sum = 0;

        System.out.println("Bought furniture:");
        while (!"Purchase".equals(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                System.out.println(matcher.group("item"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                sum+= (price * quantity);
            }
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
