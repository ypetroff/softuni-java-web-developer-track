import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class ReverseAndExclude05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt).collect(Collectors.toList());
      int n = Integer.parseInt(scanner.nextLine());
      Collections.reverse(numbers);
      Predicate<Integer> devByN = x -> x % n !=0;
      Consumer<Integer> print= x -> System.out.printf("%d ", x);
      numbers.stream().filter(devByN).forEach(print);
    }
}
