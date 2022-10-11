import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum01 {
    public static int sum = 0;
    public static int index = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        sum = findSum(numbers, index);
        System.out.println(sum);

    }

    private static int findSum(int[] numbers, int index) {
        if(index == numbers.length - 1) {
            return numbers[index];
        }

        return sum = numbers[index] + findSum(numbers, ++index);
    }

}
