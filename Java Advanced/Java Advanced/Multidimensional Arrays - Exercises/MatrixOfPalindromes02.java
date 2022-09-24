import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = populate(rowsAndCols[0], rowsAndCols[1]);

        print(matrix);
    }

    private static String[][] populate(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        char a = 97;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String str = Character.toString(a + row) + Character.toString(a + row + col) + Character.toString(a + row);         //"" + (char) (a + row) + (char) (a + row + col) + (char) (a + row);

                matrix[row][col] = str;
            }
        }
        return matrix;
    }

    public static void print(String[][] matrix) {
        for (String[] str : matrix) {
            for (String s : str) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
