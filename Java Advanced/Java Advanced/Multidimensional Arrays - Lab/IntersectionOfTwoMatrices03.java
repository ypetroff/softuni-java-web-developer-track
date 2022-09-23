import java.util.Scanner;

public class IntersectionOfTwoMatrices03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = populateMatrix(rows, cols, scanner);
        char[][] matrix2 = populateMatrix(rows, cols, scanner);

        char[][] matrix3 = combineMatrices(matrix1, matrix2, rows, cols);

        printMatrix(matrix3);
    }

    private static char[][] populateMatrix (int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String temp = scanner.nextLine();
            temp = temp.replace(" ", "");
            matrix[row] = temp.toCharArray(); // Arrays.stream(scanner.nextLine).replace(" ", "").toCharArray ?
        }

        return matrix;
    }

    public static char[][] combineMatrices(char[][] matrix1, char[][] matrix2, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] arr1 = matrix1[row];
            char[] arr2 = matrix2[row];

            for (int col = 0; col < cols; col++) {
                if(arr1[col] == arr2[col]) {
                    matrix[row][col] = arr1[col];
                }else {
                    matrix[row][col] = '*';
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
