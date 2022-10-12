package Dec21;

import java.util.Scanner;

public class ThroneConquering02 {

    private static int parisRow = 0, parisCol = 0, enemyRow = 0, enemyCol = 0;
    private static boolean reachedHelen = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int fieldRows = Integer.parseInt(scanner.nextLine());
        char[][] field = populateMatrix(fieldRows, scanner);


        while (!reachedHelen && energy > 0) {

            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            enemyRow = Integer.parseInt(input[1]);
            enemyCol = Integer.parseInt(input[2]);

            enemySpawn(field);

            switch (command) {
                case "up":
                    energy = move(field, energy, -1, 0);
                    break;
                case "down":
                    energy = move(field, energy, +1, 0);
                    break;
                case "left":
                    energy = move(field, energy, 0, -1);
                    break;
                case "right":
                    energy = move(field, energy, 0, +1);
                    break;
            }
        }

        if (reachedHelen) {

            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);

        } else {

            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);

        }

        printField(field);


    }

    private static char[][] populateMatrix(int fieldRows, Scanner scanner) {

        char[][] matrix = new char[fieldRows][fieldRows];

        for (int row = 0; row < fieldRows; row++) {

            String currentRow = scanner.nextLine();

            matrix[row] = currentRow.toCharArray();

            if (currentRow.contains("P")) {

                parisRow = row;
                parisCol = currentRow.indexOf("P");

            }
        }

        return matrix;
    }

    private static void enemySpawn(char[][] field) {

        field[enemyRow][enemyCol] = 'S';
    }

    private static int move(char[][] field, int energy, int rowChange, int colChange) {

        int newRow = parisRow + rowChange;
        int newCol = parisCol + colChange;

        energy--;


        if (validateNewCoordinates(newRow, newCol, field)) {

            field[parisRow][parisCol] = '-';

            if (field[newRow][newCol] == 'H') {

                field[newRow][newCol] = '-';
                reachedHelen = true;
                return energy;

            } else if (field[newRow][newCol] == 'S') {

                energy -= 2;

            }

            field[newRow][newCol] = energyLevel(energy);

            parisRow = newRow;
            parisCol = newCol;

        }

        return energy;
    }

    private static boolean validateNewCoordinates(int newRow, int newCol, char[][] matrix) { //error was here
        return newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[newRow].length;
   //     return newRow >= 0 && newRow < matrix[0].length && newCol >= 0 && newCol < matrix[0].length;
    }

    private static char energyLevel(int energy) {
        return energy > 0
                ? 'P'
                : 'X';
    }

    private static void printField(char[][] field) {

        for (char[] chars : field) {
            for (char aChar : chars) {

                System.out.print(aChar);

            }
            System.out.println();
        }
    }
}
