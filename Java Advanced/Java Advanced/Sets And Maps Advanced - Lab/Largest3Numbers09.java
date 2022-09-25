import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        numbers.stream().limit(3).forEach(n -> System.out.print(n + " "));

    }
}
