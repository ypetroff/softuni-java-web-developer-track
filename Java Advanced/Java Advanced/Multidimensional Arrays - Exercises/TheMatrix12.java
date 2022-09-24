import java.util.*;

public class TheMatrix12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        char[][] matrix = populateMatrix(dimensions[0], dimensions[1], scanner);

        char fillChar = scanner.nextLine().charAt(0);
        int[] currentPosition = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = currentPosition[0];
        int col = currentPosition[1];
        char startChar = matrix[row][col]; //TODO: startPoint could be currentPosition to use only one variable

        ArrayDeque<List<Integer>> prev = new ArrayDeque<>();
        prev.push(Arrays.asList(row, col));
        List<List<Integer>> visited = new ArrayList<>();
        visited.add(Arrays.asList(currentPosition[0], currentPosition[1]));
        boolean[][] checkPosition = new boolean[dimensions[0]][dimensions[1]];
       checkPosition[currentPosition[0]][currentPosition[1]] = true;

        while (!prev.isEmpty()) {
            currentPosition[0] = prev.peek().get(0);
            currentPosition[1] = prev.peek().get(1);
            prev.pop();
            goUp(currentPosition, matrix, startChar, checkPosition, prev, visited);
            goDown(currentPosition, matrix, startChar, checkPosition, prev, visited);
            goLeft(currentPosition, matrix, startChar, checkPosition, prev, visited);
            goRight(currentPosition, matrix, startChar, checkPosition, prev, visited);

        }

        for (List<Integer> list : visited) {
            row = list.get(0);
            col = list.get(1);
            matrix[row][col] = fillChar;
        }

        printMatrix(matrix);

    }

    private static void goUp(int[] currentPosition, char[][] matrix, char startChar, boolean[][] checkPosition, ArrayDeque<List<Integer>> prev, List<List<Integer>> visited) {
        int col = currentPosition[1];
        int newRow = currentPosition[0] - 1;
        if (isValid(newRow, col, matrix) && matrix[newRow][col] == startChar && !checkPosition[newRow][col]) {
           // currentPosition[0] = newRow;
            checkPosition[newRow][col] = true;
            visited.add(Arrays.asList(newRow, col));
            prev.push(Arrays.asList(newRow, col));
            goUp(currentPosition, matrix, startChar, checkPosition, prev, visited);
        }
    }

    private static void goDown(int[] currentPosition, char[][] matrix, char startChar, boolean[][] checkPosition, ArrayDeque<List<Integer>> prev, List<List<Integer>> visited) {
        int col = currentPosition[1];
        int newRow = currentPosition[0] + 1;
        if (isValid(newRow, col, matrix) && matrix[newRow][col] == startChar && !checkPosition[newRow][col]) {
        //    currentPosition[0] = newRow;
            checkPosition[newRow][col] = true;
            visited.add(Arrays.asList(newRow, col));
            prev.push(Arrays.asList(newRow, col));
            goDown(currentPosition, matrix, startChar, checkPosition, prev, visited);
        }
    }

    private static void goLeft(int[] currentPosition, char[][] matrix, char startChar, boolean[][] checkPosition, ArrayDeque<List<Integer>> prev, List<List<Integer>> visited) {
        int newCol = currentPosition[1] - 1;
        int row = currentPosition[0];
        if (isValid(row, newCol, matrix) && matrix[row][newCol] == startChar && !checkPosition[row][newCol]) {
      //      currentPosition[1] = newCol;
            checkPosition[row][newCol] = true;
            visited.add(Arrays.asList(row, newCol));
            prev.push(Arrays.asList(row, newCol));
            goLeft(currentPosition, matrix, startChar, checkPosition, prev, visited);
        }
    }

    private static void goRight(int[] currentPosition, char[][] matrix, char startChar, boolean[][] checkPosition, ArrayDeque<List<Integer>> prev, List<List<Integer>> visited) {
        int newCol = currentPosition[1] + 1;
        int row = currentPosition[0];
        if (isValid(row, newCol, matrix) && matrix[row][newCol] == startChar && !checkPosition[row][newCol]) {
        //    currentPosition[1] = newCol;
            checkPosition[row][newCol] = true;
            visited.add(Arrays.asList(row, newCol));
            prev.push(Arrays.asList(row, newCol));
            goRight(currentPosition, matrix, startChar, checkPosition, prev, visited);
        }
    }


    private static boolean isValid(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


    private static char[][] populateMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];



        for (int row = 0; row < rows; row++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            matrix[row] = input.toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}

