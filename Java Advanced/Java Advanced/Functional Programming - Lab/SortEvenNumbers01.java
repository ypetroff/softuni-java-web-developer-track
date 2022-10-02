import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] integers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        String collectedNumbers = Arrays.stream(integers).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collectedNumbers);
       String sortedNumbers =  Arrays.stream(integers)
                .sorted()
                .mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(sortedNumbers);
    }
}
