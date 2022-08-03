import java.math.BigDecimal;
import java.util.Scanner;

public class PoundsToDollars02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal GBP = new BigDecimal(scanner.nextLine());
        BigDecimal USD = GBP.multiply(BigDecimal.valueOf(1.36));

        System.out.printf("%.3f", USD);
    }
}
