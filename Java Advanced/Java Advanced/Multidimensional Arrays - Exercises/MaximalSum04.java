import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = populateMatrix(scanner, dimensions);

        maxSum(matrix);
    }


    private static int[][] populateMatrix(Scanner scanner, int[] dimensions) {
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static void maxSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE, startRow = 0, startCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length - 2; col++) {
                int sum = miniMatrix(matrix, row, col);
                if (sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMiniMatrix(matrix, startRow, startCol);
    }

    private static int miniMatrix(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }

    private static void printMiniMatrix(int[][] matrix, int row, int col) {
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
