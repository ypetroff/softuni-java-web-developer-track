import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String delimiter = "\\s+";
        int rowsAndCols = Integer.parseInt(scanner.nextLine());



        int[][] matrix = populateMatrix(rowsAndCols, scanner, delimiter);

        System.out.println(firstDiagonal(matrix));
        System.out.println(secondDiagonal(matrix, rowsAndCols));
    }

    private static int[] getLine(Scanner scanner, String delimiter) {
        return  Arrays.stream(scanner.nextLine().split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] populateMatrix(int rowsAndCols, Scanner scanner, String delimiter) {
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int row = 0; row < rowsAndCols; row++) {
            matrix[row] = getLine(scanner, delimiter);
        }
        return matrix;
    }

    public static String firstDiagonal(int[][]matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append(matrix[0][0]);
        int index1 = 0;
        int index2 = 0;
        sb.append(" ");

        for (int row = 1; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int col = 1; col < arr.length; col++) {
                if(row == index1 + 1 && col == index2 + 1) {
                    sb.append(matrix[row][col]);
                    sb.append(" ");
                    index1 = row;
                    index2 = col;
                }
            }
        }
        return sb.toString();
    }
    public static String secondDiagonal(int[][] matrix, int rowsAndCols) {
        StringBuilder sb = new StringBuilder();
        sb.append(matrix[rowsAndCols - 1][0]);
        sb.append(" ");
        int index1 = rowsAndCols - 1;
        int index2 = 0;

        for (int row = rowsAndCols - 1; row >= 0; row--) {
            for (int col = rowsAndCols - 1; col >= 0; col--) {
                if(row == index1 -1 && col == index2 + 1) {
                    sb.append(matrix[row][col]);
                    sb.append(" ");
                    index1 = row;
                    index2 = col;
                }
            }
        }
        return sb.toString();
    }
}
