package June20;

import java.util.Scanner;

public class Snake02 {

    private static final int MINIMUM_AMOUNT_OF_FOOD = 10;
    private static int snakeRow = 0, snakeCol = 0, food = 0;
    private static char[][] territory;
    private static boolean hasLeft = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        populateMatrix(scanner, n);

        while (!hasLeft && food < MINIMUM_AMOUNT_OF_FOOD) {

            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    move(-1, 0);
                    break;
                case "down":
                    move(1, 0);
                    break;
                case "left":
                    move(0, -1);
                    break;
                case "right":
                    move(0, 1);
                    break;
            }
        }

        if(hasLeft) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", food);

        printMatrix();

    }

    private static void populateMatrix(Scanner scanner, int n) {

        territory = new char[n][n];

        for (int row = 0; row < n; row++) {

            String input = scanner.nextLine();
            territory[row] = input.toCharArray();

            if(input.contains("S")) {
                snakeRow = row;
                snakeCol = input.indexOf('S');
            }
        }
    }

    private static void move(int addRow, int addCol) {

        territory[snakeRow][snakeCol] = '.';

        hasLeft = !validateCoordinates(snakeRow + addRow, snakeCol + addCol);

        if(!hasLeft) {

            snakeRow+=addRow;
            snakeCol+=addCol;

            if(territory[snakeRow][snakeCol] == '*') {
                food++;
            }else if (territory[snakeRow][snakeCol] == 'B') {
                territory[snakeRow][snakeCol] = '.';

                searchLair();
            }

            territory[snakeRow][snakeCol] = 'S';

        }
    }

    private static boolean validateCoordinates(int row, int col) {
        return row >= 0 && row < territory.length && col >= 0 && col < territory[row].length;
    }

    private static void searchLair() {

        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {

                if(territory[row][col] == 'B') {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }
    }

    private static void printMatrix() {

        for (char[] chars : territory) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
