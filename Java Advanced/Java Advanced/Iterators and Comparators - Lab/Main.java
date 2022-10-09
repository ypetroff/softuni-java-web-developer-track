

import java.util.Scanner;

public class Main {

    private static int playerRow = 0, playerCol = 0, money = 0;
    private static boolean leftTheShop = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] pastryShop = populateMatrix(scanner, n);

        while (!leftTheShop && money < 50) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    move(pastryShop, -1, 0);
                    break;
                case "down":
                    move(pastryShop, 1, 0);
                    break;
                case "left":
                    move(pastryShop, 0, -1);
                    break;
                case "right":
                    move(pastryShop, 0, 1);
                    break;
            }
        }

        if(leftTheShop) {
            System.out.println("Bad news! You are out of the pastry shop.");
        }

        if(money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", money);

        printMatrix(pastryShop);
    }

    private static char[][] populateMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];

        for (int r = 0; r < n; r++) {
            String input = scanner.nextLine();
            matrix[r] = input.toCharArray();

            if (input.contains("S")) {
                playerRow = r;
                playerCol = input.indexOf("S");
            }
        }
        return matrix;
    }

    private static void move(char[][] pastryShop, int addRow, int addCol) {

        pastryShop[playerRow][playerCol] = '-';

        leftTheShop = verifyLocation(pastryShop, playerRow + addRow, playerCol + addCol);

        if (!leftTheShop) {

            playerRow += addRow;
            playerCol += addCol;

            if (Character.isDigit(pastryShop[playerRow][playerCol]) &&
                    pastryShop[playerRow][playerCol] != '-') {
                money += Character.getNumericValue(pastryShop[playerCol][playerCol]);
            }else if(pastryShop[playerRow][playerCol] == 'P') {
                pastryShop[playerRow][playerCol] = '-';

                findSecondPillar(pastryShop);

            }

            pastryShop[playerRow][playerCol] = 'S';

        }
    }

    private static boolean verifyLocation(char[][] pastryShop, int row, int col) {
        return !(row >= 0 && row < pastryShop.length && col >= 0 && col < pastryShop[row].length);
    }

    private static void findSecondPillar(char[][] pastryShop) {

        loop:
        for (int row = 0; row < pastryShop.length; row++) {
            for (int col = 0; col < pastryShop[row].length; col++) {

                if(pastryShop[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                    break loop;
                }

            }
        }
    }

    private static void printMatrix(char[][] pastryShop) {
        for (char[] chars : pastryShop) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
