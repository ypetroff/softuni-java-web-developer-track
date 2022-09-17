import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int productsQuantity = Integer.parseInt(scanner.nextLine());
        String regex = "@[#]+[A-Z][A-Za-z0-9]{4,}[A-Z]@[#]+";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < productsQuantity; i++) {
            String product = scanner.nextLine();
            Matcher matcher = pattern.matcher(product);
            StringBuilder productGroup = new StringBuilder();
            boolean isValid = false;
            while (matcher.find()) {
                findGroup(productGroup, matcher.group());
                if(productGroup.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", productGroup);
                }
                isValid = true;
            }
            if(!isValid) {
                System.out.println("Invalid barcode");
            }
        }
    }

    private static void findGroup(StringBuilder productGroup, String productName) {
        char[] symbols = productName.toCharArray();
        for (char symbol : symbols) {
            if(Character.isDigit(symbol)) {
                productGroup.append(symbol);
            }
        }
    }
}
