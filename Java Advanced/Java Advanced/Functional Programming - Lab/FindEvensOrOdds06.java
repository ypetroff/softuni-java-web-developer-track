import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bound = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int lower = bound[0];
        int upper = bound[1];
        String evenOrOdd = scanner.nextLine();
        IntStream.rangeClosed(lower, upper)
                .filter(getFilter(evenOrOdd))
                .forEach(x -> System.out.printf("%d ", x));
    }

    private static IntPredicate getFilter(String evenOrOdd) {
        if (evenOrOdd.equals("odd")) {
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;

    }
}
