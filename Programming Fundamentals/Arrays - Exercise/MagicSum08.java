import java.util.Arrays;
import java.util.Scanner;

public class MagicSum08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int magicSum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == magicSum) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }
}
