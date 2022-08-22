import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        numbers = sumNumbers(numbers);

        String output = numbers.toString()
                .replaceAll("[\\[\\],]", "")
                .trim();

        System.out.println(output);
    }


    private static List<Integer> sumNumbers(List<Integer> numbers) {

        int cycles = numbers.size() / 2;
        for (int i = 0; i < cycles; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);

        }
        return numbers;
    }
}
