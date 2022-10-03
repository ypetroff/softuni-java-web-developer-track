import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] dividers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Double> listOfNumbers = addNumbers(n);

        for (int divider : dividers) {
            Predicate<Double> div = x -> x % divider == 0;
            listOfNumbers = listOfNumbers.stream().filter(div).collect(Collectors.toList());
        }
        listOfNumbers.forEach(x -> System.out.printf("%.0f ", x));
    }

    private static List<Double> addNumbers(int n) {
        List<Double> list = new ArrayList<>();
        for (double i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }
}

//    int n = Integer.parseInt(scan.nextLine());
//    Set<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
//            .map(Integer::parseInt).collect(Collectors.toSet());
//    Predicate<Integer> isdDivisible = num -> {
//        for (Integer number : numbers) {
//            if (num % number != 0) {
//                return false;
//            }
//        }
//        return true;
//    };
//        IntStream.range(1, n + 1).filter(isdDivisible::test).forEach(i -> System.out.printf("%d ", i));
