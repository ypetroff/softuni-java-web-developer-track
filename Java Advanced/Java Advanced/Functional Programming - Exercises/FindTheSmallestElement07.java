import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors
                .toCollection(ArrayList::new));
        Function<List<Integer>, Integer> min = FindTheSmallestElement07::findMin; // or x -> findMin(x)
        // Function<List<Integer>,Integer> getRightMostIndex=
        //                list-> list.lastIndexOf(list.stream().min(Integer::compare).orElseThrow());
        // !! numbers.lastIndexOf() !!
        System.out.println(min.apply(numbers));

    }

    private static Integer findMin(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) <= min) {
                min = numbers.get(i);
                index = i;
            }
        }
        return index;
    }
}
