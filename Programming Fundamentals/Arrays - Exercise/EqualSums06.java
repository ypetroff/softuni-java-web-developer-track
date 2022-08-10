import java.util.Arrays;
import java.util.Scanner;

public class EqualSums06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        boolean isEqual = false;



        for (int i = 0; i < arr.length; i++) {

            int leftSum = 0, rightSum = 0;
            for (int j = i; j > 0; j--) {
                leftSum+= arr[j - 1];
            }
            for (int j = i; j < arr.length - 1; j++) {
                rightSum+= arr[j + 1];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                isEqual = true;
            }
        }
        if (!isEqual) {
            System.out.println("no");
        }
    }
}
