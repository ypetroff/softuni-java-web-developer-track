import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println(arr[arr.length - 1]);
    }
}
