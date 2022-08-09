import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr1 = scanner.nextLine().split(" ");
        String[] arr2 = scanner.nextLine().split(" ");
        
        int[] firstSetOfNumbers = Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
        int[] secondSetOfNumbers = Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        boolean areIdentical = true;

        for (int i = 0; i < firstSetOfNumbers.length; i++) {
            if (firstSetOfNumbers[i] == secondSetOfNumbers[i]) {
                sum+= firstSetOfNumbers[i];
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areIdentical = false;
                break;
            }
        }

        if (areIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
