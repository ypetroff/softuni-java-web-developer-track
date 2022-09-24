import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = populateMatrix(scanner, n);

        int sumDiagonal1 = diagonal1(matrix);
        int sumDiagonal2 = diagonal2(matrix);

        System.out.println(Math.abs(sumDiagonal1 - sumDiagonal2));
    }

    private static int[][] populateMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static int diagonal1(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum+= matrix[i][i];
        }


        return sum;
    }

    private static int diagonal2(int[][] matrix) {
        int sum = matrix[0][matrix.length - 1];
        int prevCol = matrix.length - 1;

        for (int row = 1; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int col = arr.length - 1; col >= 0 ; col--) {
                if(col == prevCol - 1) {
                    sum+= matrix[row][col];
                    prevCol--;
                    break;
                }
            }
        }
        return sum;
    }
}
