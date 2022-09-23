import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String delimiter = "\\s+";
        int[] rowsAndCols = getLine(scanner, delimiter);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = populateMatrix(rows, cols, scanner, delimiter);

        int numberToFind = Integer.parseInt(scanner.nextLine());

        findNumber(numberToFind, matrix);
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

    public static void findNumber(int number, int[][] matrix) {
        List<String> positions = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];

            for (int col = 0; col < arr.length; col++) {
                if (arr[col] == number) {
                    positions.add(String.format("%d %d", row, col));
                }

            }
        }
        if(positions.isEmpty()) {
            System.out.println("not found");
        }else {
            positions.forEach(System.out::println);
        }
    }
}


