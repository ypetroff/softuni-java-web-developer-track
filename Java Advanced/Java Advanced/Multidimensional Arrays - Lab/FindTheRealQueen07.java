import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = 8;
        String delimiter = "\\s+";

        char[][] matrix = populateMatrix(scanner, dimensions, delimiter);

        List<String> positionOfQueens = findQ(matrix);
        realQueen(matrix, positionOfQueens);

    }

    private static char[][] populateMatrix(Scanner scanner, int dimensions, String delimiter) {
        char[][] matrix = new char[dimensions][dimensions];
        for (int row = 0; row < dimensions; row++) {
            String input = scanner.nextLine().replaceAll(delimiter, "");
            matrix[row] = input.toCharArray();
        }
        return matrix;
    }

    public static List<String> findQ(char[][] matrix) {
        List<String> coordinates = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            char[] arr = matrix[row];

            for (int col = 0; col < arr.length; col++) {
                if (matrix[row][col] == 'q') {
                    coordinates.add(row + " " + col);
                }
            }
        }
        return coordinates;
    }

    public static void realQueen(char[][] matrix, List<String> coordinates) {
        for (String coordinate : coordinates) {
            int row = Integer.parseInt(coordinate.split("\\s")[0]);
            int col = Integer.parseInt(coordinate.split("\\s")[1]);

            boolean up = lookUp(matrix, row, col);
            if(!up) {
                continue;
            }
            boolean down = lookDown(matrix, row, col);
            if(!down) {
                continue;
            }
            boolean right = lookRight(matrix, row, col);
            if(!right) {
                continue;
            }
            boolean left = lookLeft(matrix, row, col);
            if(!left) {
                continue;
            }
            boolean upLeft = diagonalUpLeft(matrix, row, col);
            if(!upLeft) {
                continue;
            }
            boolean upRight = diagonalUpRight(matrix, row, col);
            if(!upRight) {
                continue;
            }
            boolean downLeft = diagonalDownLeft(matrix, row, col);
            if(!downLeft) {
                continue;
            }
            boolean downRight = diagonalDownRight(matrix, row, col);

            if (downRight) {
                System.out.println(coordinate);
            }
        } ///EZ!
    }

    private static boolean lookUp(char[][] matrix, int row, int col) {
        char suspectQ = matrix[row][col];

        for (int r = row - 1; r >= 0; r--) {

            if (matrix[r][col] == suspectQ) {
                return false;
            }

        }
        return true;
    }

    private static boolean lookDown(char[][] matrix, int row, int col) {
        char suspectQ = matrix[row][col];

        for (int r = row + 1; r < matrix.length; r++) {

            if (matrix[r][col] == suspectQ) {
                return false;
            }

        }
        return true;
    }

    private static boolean lookRight(char[][] matrix, int row, int col) {
        char suspectQ = matrix[row][col];
        char[] arr = matrix[row];

        for (int c = col + 1; c < arr.length; c++) {
            if (arr[c] == suspectQ) {
                return false;
            }
        }
        return true;
    }

    private static boolean lookLeft(char[][] matrix, int row, int col) {
        char suspectQ = matrix[row][col];
        char[] arr = matrix[row];
        for (int c = col - 1; c >= 0; c--) {
            if (arr[c] == suspectQ) {
                return false;
            }
        }
        return true;
    }

    private static boolean diagonalUpLeft(char[][] matrix, int row, int col) {
        char suspectQ = matrix[row][col];

        int index1 = row;
        int index2 = col;

        for (int r = row - 1; r >= 0; r--) {

            for (int c = col - 1; c >= 0; c--) {
                if (r == index1 - 1 && c == index2 - 1) {
                    index1 = r;
                    index2 = c;
                    if (matrix[r][c] == suspectQ) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean diagonalUpRight(char[][] matrix, int row, int col) {
        char suspectQ = matrix[row][col];
        int index1 = row;
        int index2 = col;

        for (int r = row - 1; r >= 0; r--) {

            char[] arr = matrix[r];

            for (int c = col + 1; c < arr.length; c++) {
                if (r == index1 - 1 && c == index2 + 1) {
                    index1 = r;
                    index2 = c;
                    if (matrix[r][c] == suspectQ) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean diagonalDownLeft(char[][] matrix, int row, int col) {
        char suspectQ = matrix[row][col];

        int index1 = row;
        int index2 = col;

        for (int r = row + 1; r < matrix.length; r++) {

            for (int c = col - 1; c >= 0; c--) {
                if (r == index1 + 1 && c == index2 - 1) {
                    index1 = r;
                    index2 = c;
                    if (matrix[r][c] == suspectQ) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean diagonalDownRight(char[][] matrix, int row, int col) {
        char suspectQ = matrix[row][col];
        int index1 = row;
        int index2 = col;

        for (int r = row + 1; r < matrix.length; r++) {

            char[] arr = matrix[r];

            for (int c = col + 1; c < arr.length; c++) {
                if (r == index1 + 1 && c == index2 + 1) {
                    index1 = r;
                    index2 = c;
                    if (matrix[r][c] == suspectQ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}

//    public static void printMatrix(char[][] matrix) {
//        for (char[] chars : matrix) {
//            for (char c : chars) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }
//    }