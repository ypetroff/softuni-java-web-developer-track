import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator08 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> listOfNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> evensAtTheStart = (CustomComparator08::compare);

        listOfNumbers.stream().sorted(evensAtTheStart).forEach(x -> System.out.printf("%d ", x));


    }

    private static int compare(Integer x, Integer y) {
        if (x % 2 != 0 && y % 2 == 0) {
            return 1;
        } else if (x % 2 == 0 && y % 2 != 0) {
            return -1;
        }
        return x.compareTo(y);
    }
}
