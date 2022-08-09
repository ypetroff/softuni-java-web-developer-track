import java.util.Arrays;
import java.util.Scanner;


public class CondenseArray_V2_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        while (arr.length > 1) {
            int[] temp = new int[arr.length - 1];

            for (int i = 0; i < arr.length - 1; i++) {
                temp[i] = arr[i] + arr[i + 1];
            }

            arr = temp;
        }
        System.out.println(arr[0]);
    }
}
