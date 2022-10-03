import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Function<Integer[], Integer> min = x -> Arrays.stream(x).mapToInt(i -> i).min().orElse(0);
        System.out.println(min.apply(numbers));
    }
}
