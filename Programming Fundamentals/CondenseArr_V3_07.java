import java.util.Arrays;
import java.util.Scanner;

public class CondenseArr_V3_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//trash!
        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int[] temp = new int[arr.length - 1];
            for (int j = 0; j < arr.length - 1 ; j++) {
                temp[j] = arr[j] + arr[j+1];
            }
            arr = temp;
        }
        System.out.println(arr[0]);
    }
}
