import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        String delimiter = "\\s+";

        int[][] matrix = populateMatrix(scanner, rows, delimiter);

        int[] wrongValueLocation = getLine(scanner, delimiter);
        int wrongValue = matrix[wrongValueLocation[0]][wrongValueLocation[1]];

        List<String> coordinates = findWrongValues(matrix, wrongValue);

        int[][] modifiedMatrix = modifyValues(matrix, coordinates, wrongValue);

        printMatrix(modifiedMatrix);


    }


    private static int[][] populateMatrix(Scanner scanner, int rows, String delimiter) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getLine(scanner, delimiter);
        }
        return matrix;
    }

    public static int[] getLine(Scanner scanner, String delimiter) {
        return Arrays.stream(scanner.nextLine().split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static List<String> findWrongValues(int[][] matrix, int wrongValue) {
        List<String> coordinates = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];

            for (int col = 0; col < arr.length; col++) {
                if (matrix[row][col] == wrongValue) {
                    coordinates.add(row + " " + col);
                }
            }
        }
        return coordinates;
    }

    private static int[][] modifyValues(int[][] matrix, List<String> coordinates, int wrongValue) {
        for (String coordinate : coordinates) {
            int row = Integer.parseInt(coordinate.split("\\s")[0]);
            int col = Integer.parseInt(coordinate.split("\\s")[1]);
            matrix[row][col] = 0;



                matrix[row][col] += (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue &&
                        checkPrev(row + 1, col, coordinates))
                        ? matrix[row + 1][col]
                        : 0;
                matrix[row][col] += (row - 1 >= 0 && matrix[row - 1][col] != wrongValue &&
                        checkPrev(row - 1, col, coordinates))
                        ? matrix[row - 1][col]
                        : 0;
                matrix[row][col] += (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue &&
                        checkPrev(row, col + 1, coordinates))
                        ? matrix[row][col + 1]
                        : 0;
                matrix[row][col] += (col - 1 >= 0 && matrix[row][col - 1] != wrongValue &&
                        checkPrev(row, col - 1, coordinates))
                        ? matrix[row][col - 1]
                        : 0;



        }
        return matrix;
    }

    private static boolean checkPrev(int row, int col, List<String> coordinates) {
        String loc = row + " " + col;

        for (String coordinate : coordinates) {
            if(coordinate.equals(loc)) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
