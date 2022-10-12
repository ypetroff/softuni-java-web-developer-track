package Dec20;

import java.util.Scanner;

public class Selling02 {

    private static final int MINIMUM_AMOUNT_OF_MONEY = 50;

    private static int sRow = 0, sCol = 0, money = 0;
    private static char[][] bakery;
    private static boolean hasLeftBakery = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        populateMatrix(scanner, n);

        while (!hasLeftBakery && money < MINIMUM_AMOUNT_OF_MONEY) {

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

        if(hasLeftBakery) {
            System.out.println("Bad news, you are out of the Dec20.bakery.");
        }

        if(money >= MINIMUM_AMOUNT_OF_MONEY) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", money);

        printBakery();

    }

    private static void populateMatrix(Scanner scanner, int n) {

        bakery = new char[n][n];

        for (int row = 0; row < n; row++) {

            String input = scanner.nextLine();
            bakery[row] = input.toCharArray();

            if (input.contains("S")) {
                sRow = row;
                sCol = input.indexOf('S');
            }
        }
    }

    private static void move(int addRow, int addCol) {

        bakery[sRow][sCol] = '-';
        hasLeftBakery = !validateCoordinates(sRow + addRow, sCol + addCol);

        if (!hasLeftBakery) {
            sRow += addRow;
            sCol += addCol;

            char c = bakery[sRow][sCol];
            if (Character.isDigit(c)) {
                money += Character.getNumericValue(c);
            } else if (c == 'O') {
                bakery[sRow][sCol] = '-';

                moveToOtherPillar();
            }

            bakery[sRow][sCol] = 'S';
        }
    }

    private static boolean validateCoordinates(int row, int col) {
        return row >= 0 && row < bakery.length && col >= 0 && col < bakery[row].length;
    }

    private static void moveToOtherPillar() {

        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {

                if (bakery[row][col] =='O') {
                    sRow = row;
                    sCol = col;
                }

            }
        }
    }

    private static void printBakery() {

        for (char[] chars : bakery) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
