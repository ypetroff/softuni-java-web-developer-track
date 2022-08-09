
import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arrInput = input.split(" ");
        int[] numbers = Arrays.stream(arrInput).mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        System.out.println(sum);
    }
}
