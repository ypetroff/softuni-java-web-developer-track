import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int sumOdd = 0, sumEven = 0;

        for (int i : arr) {
            if (i % 2 == 0) {
                sumEven += i;
            } else {
                sumOdd += i;
            }
        }
        System.out.println(sumEven - sumOdd);
    }
}
