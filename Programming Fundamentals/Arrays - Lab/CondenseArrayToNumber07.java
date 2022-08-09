import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
// trash!
        if (arr.length < 2) {
            System.out.printf("%d", arr[0]);
        } else {
            for (int i = 0; i < arr.length; i++) {
                int[] condensed = new int[arr.length - 1];
                // Arrays.fill(condensed, arr[i] + arr[i + 1]);
                for (int j = 0; j < condensed.length; j++) {
                    condensed[j] = arr[j] + arr[j + 1];
                }
                arr = condensed;
            }
            for (int i : arr) {
                sum += i;
            }
            System.out.println(sum);
        }
    }
}
