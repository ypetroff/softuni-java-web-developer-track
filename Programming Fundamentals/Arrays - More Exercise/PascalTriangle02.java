import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PascalTriangle02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[] previousRowValues = new int[0];
        int numbersPerRow = 1;

        for (int row = 0; row < rows; row++) {

             int[] currentRowValues = new int[numbersPerRow];
            for (int numberIndex = 0; numberIndex < numbersPerRow; numberIndex++) {
                if ( numberIndex == 0) {
                    currentRowValues[0] = 1;
                    continue;
                }

                if (numberIndex == numbersPerRow - 1) {
                    currentRowValues[numbersPerRow - 1] = 1;
                }else {
                    currentRowValues[numberIndex] = previousRowValues[numberIndex - 1] + previousRowValues[numberIndex];
                }
            }
            previousRowValues = currentRowValues;
            numbersPerRow++;

            String output = Arrays.stream(currentRowValues)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(output);
        }

    }
}
