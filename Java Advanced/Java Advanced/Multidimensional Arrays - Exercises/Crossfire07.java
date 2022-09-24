import java.util.*;
import java.util.stream.IntStream;

public class Crossfire07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Integer[][] matrix = populateMatrix(dimensions);

        String command;
        while(!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] instructions = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            destroyElements(matrix, instructions[0], instructions[1], instructions[2]);

        }

        printMatrix(matrix);

    }



    private static boolean isInBounds(Integer[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void destroyElements(Integer[][] matrix, int row, int col, int radius) {
        IntStream.rangeClosed(row - radius, row + radius).filter(r -> isInBounds(matrix, r, col) && r != row)
                .forEach(r -> matrix[r][col] = null);
        IntStream.rangeClosed(col - radius, col + radius).filter(c -> isInBounds(matrix, row, c))
                .forEach(c -> matrix[row][c] = null);
        IntStream.range(0, matrix.length).forEach(r -> matrix[r] = Arrays.stream(matrix[r])
                .filter(Objects::nonNull).toArray(Integer[]::new));
    }


    private static Integer[][] populateMatrix(int[] dimensions) {
        Integer[][] matrix = new Integer[dimensions[0]][dimensions[1]];
        int n = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = n++;
            }
        }
        return matrix;
    }

    private static void printMatrix(Integer[][] matrix) {
        for (Integer[] integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}

