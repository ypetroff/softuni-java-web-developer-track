import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String delimiter = ", ";

         int[] rowsAndCols = getLine(scanner, delimiter);

         int rows = rowsAndCols[0];
         int cols = rowsAndCols[1];

         int[][] matrix = populateMatrix(rows, cols, scanner, delimiter);

         int sum = findSum(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int[] getLine(Scanner scanner, String delimiter) {
        return  Arrays.stream(scanner.nextLine().split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] populateMatrix(int rows, int cols, Scanner scanner, String delimiter) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = getLine(scanner, delimiter);
        }
        return matrix;
    }

    public static int findSum(int[][] matrix) {
        int sum = 0;
        for (int[] arr : matrix) {
            for (int i : arr) {
                sum += i;
            }
        }
        return sum;
    }
}
