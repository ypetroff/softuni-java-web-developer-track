package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = populateMatrix(x, y);


        String command = scanner.nextLine();

        long sum = 0;

        while (!command.equals("Let the Force be with you")) {

            int[] jediStartPosition = Arrays.stream(command.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] evilPowerStartPosition = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int row = evilPowerStartPosition[0];
            int col = evilPowerStartPosition[1];

            evilForceMovement(matrix, row, col);

            row = jediStartPosition[0];
            col = jediStartPosition[1];

            sum = jediMove(matrix, sum, row, col);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static int[][] populateMatrix(int x, int y) {

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int row = 0; row < x; row++) {
            for (int column = 0; column < y; column++) {
                matrix[row][column] = value++;
            }
        }

        return matrix;
    }

    private static void evilForceMovement(int[][] matrix, int row, int col) {
        while (row >= 0 && col >= 0) {

            if (row < matrix.length && col < matrix[0].length) {

                matrix[row][col] = 0;

            }
            row--;
            col--;
        }
    }

    private static long jediMove(int[][] matrix, long sum, int row, int col) {
        while (row >= 0 && col < matrix[1].length) {

            if (row < matrix.length && col >= 0 && col < matrix[0].length) {

                sum += matrix[row][col];

            }

            col++;
            row--;
        }
        return sum;
    }
}
