import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(result -> System.out.print(result + " "));
    }
}
