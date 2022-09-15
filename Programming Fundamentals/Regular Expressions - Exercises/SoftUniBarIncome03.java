import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
       // String regex = "\\%(?<name>[A-Z][a-z]+)\\%<(?<product>\\w+)>\\|(?<quantity>[\\d]+)\\|(?<price>[\\d]+\\.[\\d]*)\\$";
        String regex = "\\%(?<name>[A-Z][a-z]+)\\%[^$%|.]*<(?<product>\\w+)>[^$%|.]*\\|(?<quantity>[\\d]+)\\|[^$%|.]*?(?<price>[\\d]+\\.?[\\d]*)\\$";
        Pattern pattern = Pattern.compile(regex);
double totalSum = 0;
        while(!"end of shift".equals(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                System.out.printf("%s: %s - %.2f%n", name, product, price * quantity);
                totalSum+= (price * quantity);
            }

        }
        System.out.printf("Total income: %.2f", totalSum);
    }
}
