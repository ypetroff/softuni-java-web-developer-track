package Aug20;

import java.util.Scanner;

public class Bee02 {

    private final static int MINIMUM_POLLINATED_FLOWERS_NEEDED = 5;

    private static int beeRow = 0, beeCol = 0, pollinatedFlowers = 0;
    private static char[][] field;
    private static boolean hasLeftField = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        populateMatrix(scanner, n);

        String command;
        while (!hasLeftField && !(command = scanner.nextLine()).equals("End")) {

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

        if (hasLeftField) {
            System.out.println("The bee got lost!");
        }

        if (pollinatedFlowers < MINIMUM_POLLINATED_FLOWERS_NEEDED) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",
                    MINIMUM_POLLINATED_FLOWERS_NEEDED - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }

        printMatrix();
    }

    private static void populateMatrix(Scanner scanner, int n) {
        field = new char[n][n];

        for (int row = 0; row < n; row++) {

            String input = scanner.nextLine();

            field[row] = input.toCharArray();

            if (input.contains("B")) {
                beeRow = row;
                beeCol = input.indexOf('B');
            }

        }
    }

    private static void move(int addRow, int addCol) {

        field[beeRow][beeCol] = '.';

        hasLeftField = !verifyCoordinates(beeRow + addRow, beeCol + addCol);

        if (!hasLeftField) {

            beeRow += addRow;
            beeCol += addCol;

            if(field[beeRow][beeCol] == 'f') {
                pollinatedFlowers++;
            }else if(field[beeRow][beeCol] == 'O') {
                move(addRow, addCol);
            }

            field[beeRow][beeCol] = 'B';
        }

    }

    private static boolean verifyCoordinates(int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
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
