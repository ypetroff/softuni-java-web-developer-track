import java.util.Scanner;

public class FillTheMatrix01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int dimensions = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[dimensions][dimensions];
       populateMatrix(matrix, dimensions, type);

        printMatrix(matrix);
    }

    private static void populateMatrix(int[][] matrix, int dimensions, String type) {




        switch (type) {
            case "A":
                typeA(matrix, dimensions);
                break;
            case "B":
                typeB(matrix, dimensions);
                break;
            default:
                System.out.println("WTF?");
        }
    }


    private static void typeA(int[][] matrix, int dimensions) {
        int prev = 0;
        for (int col = 0; col < dimensions; col++) {
            for (int row = 0; row < dimensions; row++) {
                matrix[row][col] = prev + 1;
                prev++;
            }

        }
    }

    private static void typeB(int[][] matrix, int dimensions) {
        int prev = 0;
        for (int col = 1; col <= dimensions; col++) {
            if(col % 2 != 0) {
                for (int row = 0; row < dimensions; row++) {
                    matrix[row][col - 1] = prev + 1;
                    prev++;
                }
            }else {
                for (int row = dimensions - 1; row >= 0; row--) {
                    matrix[row][col - 1] = prev + 1;
                    prev++;
                }
            }
        }
    }


    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
