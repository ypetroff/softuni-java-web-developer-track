import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");
        Function <String, Integer> parse = Integer::parseInt;

        System.out.printf("Count = %d%n", numbers.length);
      int sum = Arrays.stream(numbers).map(parse).mapToInt(Integer::intValue).sum();
        System.out.printf("Sum = %d", sum);

    }
}
