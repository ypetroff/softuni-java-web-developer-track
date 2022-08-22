import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        numbers = sumListElements(numbers);

        printNumbers(numbers);
    }

    private static List<Double> sumListElements(List<Double> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));

                numbers.remove(i + 1);
                i = -1;
            }
        }
        return numbers;
    }

    private static void printNumbers(List <Double> numbers) {
        for (Double number : numbers) {
            System.out.print(new DecimalFormat("0.#").format(number) + " ");
        }
    }
}


