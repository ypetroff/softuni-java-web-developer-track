import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getLine(scanner);
        int[][]matrix = populateMatrix(dimensions, scanner);

        String command;

        while(!"END".equals(command=scanner.nextLine())) {
            String[] swap = command.split("\\s+");
            if(swap[0].equals("swap") && swap.length == 5) {
                int row1 = Integer.parseInt(swap[1]);
                int col1 = Integer.parseInt(swap[2]);
                int row2 = Integer.parseInt(swap[3]);
                int col2 = Integer.parseInt(swap[4]);

                boolean validRows = row1 >= 0 && row2 >= 0 && row1 < dimensions[0] && row2 < dimensions[0];
                boolean validCols = col1 >= 0 && col2 >= 0 && col1 < dimensions[1] && col2 < dimensions[1];

                if(validRows && validCols) {
                    swapElements(matrix, row1, col1, row2, col2);
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static int[] getLine(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
    private static int[][] populateMatrix (int[] rowsAndCols, Scanner scanner) {
        int[][] matrix = new int[rowsAndCols[0]][rowsAndCols[1]];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getLine(scanner);
        }
        return matrix;
    }

    private static void swapElements(int[][] matrix, int row1, int col1, int row2, int col2) {
        int element = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = element;

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] elements : matrix) {
            for (int element : elements) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
