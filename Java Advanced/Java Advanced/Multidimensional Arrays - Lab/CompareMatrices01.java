import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String delimiter = "\\s+";

        int[] rowsAndCols = getLine(scanner, delimiter);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix1 = populateMatrix(rows, cols, scanner, delimiter);

        rowsAndCols = getLine(scanner, delimiter);
        rows = rowsAndCols[0];
        cols = rowsAndCols[1];


        int[][] matrix2 = populateMatrix(rows, cols, scanner, delimiter);

        System.out.println(areIdentical(matrix1, matrix2)
                ? "equal"
                : "not equal");

    }

    private static int[] getLine(Scanner scanner, String delimiter) {
        return Arrays.stream(scanner.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] populateMatrix(int rows, int cols, Scanner scanner, String delimiter) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = getLine(scanner, delimiter);
        }
        return matrix;
    }

    private static boolean areIdentical(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int row = 0; row < matrix1.length; row++) {
            int[] arr1 = matrix1[row];
            int[] arr2 = matrix2[row];

            if (arr1.length != arr2.length) {
                return false;
            }

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
        }

        return true;
    }

}
