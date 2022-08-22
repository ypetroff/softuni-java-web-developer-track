import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        printOutput(numbers);
    }

    private static void printOutput(List<Integer> numbers) {
        numbers = findAndRemoveNegatives(numbers);
        boolean isEmpty = numbers.isEmpty();
        if(isEmpty) {
            System.out.println("empty");
        }else {
            Collections.reverse(numbers);
            String output = numbers.toString().replaceAll("[\\[\\],]", "");
            System.out.println(output);
        }
    }

    private static List<Integer> findAndRemoveNegatives(List<Integer> numbers) {
        numbers.removeIf(number -> number < 0);
        return numbers;
    }
}
