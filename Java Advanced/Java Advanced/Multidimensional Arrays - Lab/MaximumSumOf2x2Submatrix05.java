import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String delimiter = ", ";
        int[] rowsAndCols = getLine(scanner, delimiter);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = populateMatrix(rows, cols, scanner, delimiter);

        submatrixAndBiggestSum(matrix);
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

    public static void submatrixAndBiggestSum(int[][] matrix) {
        int sum;
        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length - 1; col++) {
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if(sum > maxSum) {
                    maxSum = sum;
                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col + 1];
                    subMatrix[1][0] = matrix[row + 1][col];
                    subMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        for (int[] element : subMatrix) {
            for (int e : element) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
