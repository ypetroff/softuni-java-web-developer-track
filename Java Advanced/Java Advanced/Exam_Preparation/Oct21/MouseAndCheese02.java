package Oct21;

import java.util.Scanner;

public class MouseAndCheese02 {

    private final static int MINIMUM_AMOUNT_OF_CHEESE_REQUIRED = 5;
    private static int mouseRow = 0, mouseCol = 0, cheeseEaten = 0;
    private static boolean hasLeftTerritory = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] mouseTerritory = createMatrix(scanner, n);

        String command;

        while (!hasLeftTerritory && !(command = scanner.nextLine()).equals("end")) {

            switch (command) {
                case "up":
                    move(mouseTerritory, -1, 0);
                    break;
                case "down":
                    move(mouseTerritory, 1, 0);
                    break;
                case "left":
                    move(mouseTerritory, 0, -1);
                    break;
                case "right":
                    move(mouseTerritory, 0, 1);
                    break;
                default:
                    break;
            }
        }

        if (hasLeftTerritory) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",
                    MINIMUM_AMOUNT_OF_CHEESE_REQUIRED - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        printMatrix(mouseTerritory);
    }

    private static char[][] createMatrix(Scanner scanner, int n) {

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {

            String currentRow = scanner.nextLine();
            matrix[row] = currentRow.toCharArray();

            if (currentRow.contains("M")) {
                mouseRow = row;
                mouseCol = currentRow.indexOf("M");
            }
        }
        return matrix;
    }

    private static void move(char[][] mouseTerritory, int addRow, int addCol) {

        mouseTerritory[mouseRow][mouseCol] = '-';

        int newRow = mouseRow + addRow;
        int newCol = mouseCol + addCol;

        hasLeftTerritory = verifyCoordinates(mouseTerritory, newRow, newCol);

        if (!hasLeftTerritory) {

            mouseRow = newRow;
            mouseCol = newCol;


            if (mouseTerritory[mouseRow][mouseCol] == 'c') {
                cheeseEaten++;
            }

            if (mouseTerritory[newRow][newCol] == 'B') {
                move(mouseTerritory, addRow, addCol);
                mouseTerritory[newRow][newCol] = '-';
            }

            mouseTerritory[mouseRow][mouseCol] = 'M';

        }

    }

    private static boolean verifyCoordinates(char[][] mouseTerritory, int newRow, int newCol) {
        return !(newRow >= 0 && newRow < mouseTerritory.length && newCol >= 0 && newCol < mouseTerritory[newRow].length);
    }

    private static void printMatrix(char[][] mouseTerritory) {

        for (char[] chars : mouseTerritory) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
