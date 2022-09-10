import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class LettersChangeNumbers08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal sum = new BigDecimal("0.00");
        String[] strings = scanner.nextLine().trim().split("\\s+");
        for (String string : strings) {
            char firstLetter = string.charAt(0);
            double number = Double.parseDouble(string.substring(1, string.length() - 1));

            char secondLetter = string.charAt(string.length() - 1);

            if (firstLetter > 64 && firstLetter < 91) { //or Character.isUppercase(firstLetter)
                int denominator = firstLetter - 64;
                double fraction = number / denominator;
                sum = sum.add(BigDecimal.valueOf(fraction));
            } else if (firstLetter > 96 && firstLetter < 123) {
                int factor = firstLetter - 96;
                double product = number * factor;
                sum = sum.add(BigDecimal.valueOf(product));
            }
            if (secondLetter > 64 && secondLetter < 91) { /// ... isLowercase
                int subtrahend = secondLetter - 64;
                sum = sum.subtract(BigDecimal.valueOf(subtrahend));
            } else if (secondLetter > 96 && secondLetter < 123) {
                int term = secondLetter - 96;
                sum = sum.add(BigDecimal.valueOf(term));

            }
        }
        sum = sum.setScale(2, RoundingMode.HALF_UP);
        System.out.printf("%s", sum);

    }
}
