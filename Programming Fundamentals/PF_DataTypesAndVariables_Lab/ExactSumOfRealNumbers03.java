import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersToAdd = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < numbersToAdd; i++) {
            BigDecimal currentNumber = new BigDecimal(scanner.nextLine());
            sum = sum.add(currentNumber);
        }
        System.out.println(sum);
    }
}
