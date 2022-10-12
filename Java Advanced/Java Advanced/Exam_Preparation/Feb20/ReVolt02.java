package Feb20;

import java.util.Scanner;

public class ReVolt02 {

    private static int playerRow = 0, playerCol = 0;
    private static char[][] field;
    private static boolean playerWon = false, bonusOrTrap = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countOfCommand = Integer.parseInt(scanner.nextLine());

        populateMatrix(scanner, n);


        while (!playerWon && countOfCommand-- > 0) {

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

        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix();
    }

    private static void populateMatrix(Scanner scanner, int n) {

        field = new char[n][n];

        for (int row = 0; row < n; row++) {

            String input = scanner.nextLine();
            field[row] = input.toCharArray();

            if (input.contains("f")) {
                playerRow = row;
                playerCol = input.indexOf('f');
            }
        }
    }

    private static void move(int addRow, int addCol) {

        if(!bonusOrTrap) {
            field[playerRow][playerCol] = '-';
        }


        boolean hasLeft = verifyCoordinates(playerRow + addRow, playerCol + addCol);

        if (!hasLeft) {
            playerRow += addRow;
            playerCol += addCol;
        }

        if(field[playerRow][playerCol] == 'F') {
            playerWon = true;
        }else if (field[playerRow][playerCol] == 'B') {
            bonusOrTrap = true;
            move(addRow, addCol);
        }else if (field[playerRow][playerCol] == 'T') {
            bonusOrTrap = true;
            move(-addRow, - addCol);
        }

        field[playerRow][playerCol] = 'f';
        bonusOrTrap = false;


    }

    private static boolean verifyCoordinates(int row, int col) {

        if (row < 0) {
            playerRow = field.length - 1;
            return true;
        } else if (row >= field.length) {
            playerRow = 0;
            return true;
        }

        if (col < 0) {
            playerCol = field[row].length - 1;
            return true;
        } else if (col >= field[row].length) {
            playerCol = 0;
            return true;
        }
        return false;
    }

    private static void printMatrix() {

        for (char[] chars : field) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
